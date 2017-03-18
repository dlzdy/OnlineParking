(function () { //作用：模块开发，做到不与其他模块隔离（如防止相同的变量被覆盖）
    var billsList = angular.module("BillsList", ["appOnline"]);
    billsList.controller("ctrlBills", ['$scope', '$http', '$location', '$window', 'PublicService',
        function ($scope, $http, $location, $window, PublicService) {

            $scope.loadingPage = true;

            //判断是否是ios访问 true为是
            var isIOS = $location.search().isIOS;

            /**
             * 跳转详情页
             * return   obj  parkingOrderParkingInfoId,
             parkingOrderCarNo,
             parkingImg,
             parkingName,
             parkingOrderCarEnterTime,
             parkingOrderCarExitTime,
             parkingOrderCarStayTime,
             parkingOrderCost,
             isCurrentOrder,
             parkingOrderPayState
             * */
            $scope.goBillsDetail = function (obj) {
                //$scope.pageBills = !$scope.pageBills;
                $scope.billsInfo = angular.copy(obj);
                $scope.billsInfo.parkingOrderCarStayTime = $scope.rsTime($scope.billsInfo.parkingOrderCarEnterTime, $scope.billsInfo.parkingOrderCarExitTime);

                console.log(PublicService.json2str($scope.billsInfo));

                if (isIOS == "true") {
                    PublicService.sendCommand("billInfo", PublicService.json2str($scope.billsInfo));
                } else {
                    client.goBillsDetail(PublicService.json2str($scope.billsInfo));
                }
            }
            $scope.rsTime = function (d1, d2) {
                var sta = d1.replace(/-/g, "/") ;
                if(!(!d2 && typeof(d2)!="undefined" && d2!=0)){
                	var end = d2.replace(/-/g, "/");
                	 var date1 = new Date(sta);  //开始时间
                     var date2 = new Date(end);    //结束时间
                     var date3 = date2.getTime() - date1.getTime()  //时间差的毫秒数
                     //计算出相差天数
                     var days = Math.floor(date3 / (24 * 3600 * 1000))
                     //计算出小时数
                     var leave1 = date3 % (24 * 3600 * 1000)    //计算天数后剩余的毫秒数
                     var hours = Math.floor(leave1 / (3600 * 1000)) + days * 24  //计算相差分钟数
                     var leave2 = leave1 % (3600 * 1000)        //计算小时数后剩余的毫秒数
                     var minutes = Math.floor(leave2 / (60 * 1000))                     //计算相差秒数
                     var leave3 = leave2 % (60 * 1000)      //计算分钟数后剩余的毫秒数
                     var seconds = Math.round(leave3 / 1000)
                     //alert(" 相差 " + days + "天 " + hours + "小时 " + minutes + " 分钟" + seconds + " 秒")

                     hours = hours > 9 ? hours : '0' + hours;
                     minutes = minutes > 9 ? minutes : '0' + minutes;
                     return hours + ':' + minutes;
                }
                return "" ;
            }


            $scope.pageBack = function () {
                $scope.pageBills = !$scope.pageBills;
                console.log($scope.pageBills);
            }
            //filter
            $scope.billCurrent = function (item) {
                return item.parkingOrderPayState === "NoPaid";
            }
        }]
    );

    /**
     * 订单详情
     * @url    app/index.html#/bills-detail
     * @param   parkingOrderParkingInfoId 停车场ID
     * @param   isCurrentOrder 是否为当前订单 true 当前订单  false 历史订单
     * @param   isExit 是否支付 true 已经支付 false 未支付
     * @param   parkingOrderCarNo 车牌号
     * @param   parkingOrderCarEnterTime 进厂时间
     * @param   parkingOrderCarExitTime 出厂时间
     * @param   parkingOrderCarStayTime 经停时间
     * @param   parkingOrderCost 支付金额
     * @param   parkingName 停车场名称
     * @param   parkingOrderPayState 支付状态 NoPaid未支付
     */
    //parkingOrderCarNo=津A8266&parkingOrderCarExitTime=2015-09-08 15:09&parkingName=朝阳区停车场&isCurrentOrder=true&parkingOrderCarEnterTime=2015-09-08 15:09&parkingOrderCarStayTime=18秒&parkingOrderCost=0.01
    var BillsDetail = angular.module("BillsDetail", ["appOnline"]);
    BillsDetail.controller("ctrlBillsDetail", function ($scope, $http, $location, PublicService) {
        $scope.parameters = $location.search();

        $scope.parkingOrderId = $scope.parameters.parkingOrderId;
        $scope.parkingOrderParkingInfoId = $scope.parameters.parkingOrderParkingInfoId;
        $scope.isCurrentOrder = $scope.parameters.isCurrentOrder; //判断是否为当前订单
        $scope.isExit = $scope.parameters.isExit; //判断是否出厂

        $scope.parkingOrderCarNo = $scope.parameters.parkingOrderCarNo; //车牌号
        $scope.parkingOrderCarEnterTime = $scope.parameters.parkingOrderCarEnterTime || ''; //进场时间
        $scope.parkingOrderCarExitTime = $scope.parameters.parkingOrderCarExitTime || ''; //出厂时间
        $scope.parkingOrderCarStayTime = $scope.parameters.parkingOrderCarStayTime; //经停时间
        $scope.parkingOrderCost = $scope.parameters.parkingOrderCost || ''; //支付金额
        $scope.isIOS = $scope.parameters.isIOS; //判断是否为ios设备
        if ($scope.parkingOrderCost == '') { //如果支付金额为空，则隐藏 元
            $scope.showCost = false;
        } else {
            $scope.showCost = true;
        }

        var url = '/OnlineParking/rest/getParkingInfoById?parkingInfoId=' + $scope.parkingOrderParkingInfoId;
        PublicService.getListByURL(url)
            .success(function (data) {
                //$scope.chargeData = data.datas;
                $scope.parkingName = data.datas.parkingInfoName || ''; //停车场名称
            })
            .error(function () {
                $scope.parkingName = ''
            });

        if ($scope.parameters.isExit == "true") { //未出场订单
            $scope.showBillDetail = false;//隐藏经停时间和金额
        } else { //已出场订单
            $scope.showBillDetail = true;//显示经停时间和金额
        }

        //显示在线支付按钮
        if ($scope.parameters.parkingOrderPayState == "NoPaid" && $scope.parkingOrderCarExitTime == "") { //未支付且未出场
            $scope.visible = false; //隐藏
        } else if ($scope.parameters.parkingOrderPayState == "NoPaid" && $scope.parkingOrderCarExitTime != "") {
            $scope.visible = true;//显示
        } else {
            $scope.visible = false;
        }


        /*获取年月日*/
        $scope.getYMD = function (str) {
            if (str == "") {
                return "";
            }
            return str.substr(0, 10);
        }

        /*获取时分*/
        $scope.getHM = function (str) {
            if (str == "") {
                return "";
            }
            return str.substr(11, 16);
        }

        $scope.pay = function () {
            if ($scope.isIOS == "true") {
                PublicService.sendCommand("payBtnAction", "payBtnAction");
            } else {
                client.pay();
            }
        }

        $scope.sfmx = function () {
            if ($scope.isIOS == "true") {
                PublicService.sendCommand("pushtoPriceInfoVC", "parkingOrderParkingInfoId");
            } else {
                //console.log($scope.parkingOrderParkingInfoId)
                client.sfmx($scope.parkingOrderParkingInfoId);
            }
        }


        /*$scope.showInfoFromJava=function(str){
         var rs=str.split(',');
         $("#parkingOrderCarExitTime").text(rs[0]);
         $("#parkingOrderCarStayTime").text(rs[1]);
         $("#parkingOrderCost").text(rs[2]);
         alert(rs);
         $('.ills-date-box,#payOtherRow').addClass('show');

         }*/
    });


    /**
     * 数据分页
     * @module
     * @return
     */
    angular.module('pagination', ['infinite-scroll'])
        .controller('ctrlBillsHistory', function ($scope, $location, Reddit) {
            $scope.parameters = $location.search();
            var clientUserSecurity = $scope.parameters.clientUserSecurity;
            var parkingOrderClientUserId = $scope.parameters.parkingOrderClientUserId;
            var isIOS = $scope.parameters.isIOS;
            console.log($scope.parameters);
            $scope.reddit = new Reddit(clientUserSecurity, parkingOrderClientUserId,isIOS);
        })
        .factory('Reddit', function ($http, PublicService) {
            var Reddit = function (clientUserSecurity, parkingOrderClientUserId,isIOS) {
                this.items = [];
                this.busy = false;
                this.after = '';
                this.currIndex = 0;
                this.tipTxt = '数据加载中...';
                this.parkingOrderClientUserId = parkingOrderClientUserId;
                this.clientUserSecurity = clientUserSecurity;
                this.isIOS = isIOS ;
            };

            Reddit.prototype.nextPage = function () {
                if (this.busy) return;
                this.busy = true;
                this.currIndex++;
                var url = "/OnlineParking/rest/queryParkOrderLimit?" +
                    "parkingOrderClientUserId=" + this.parkingOrderClientUserId +
                    "&clientUserSecurity=" + this.clientUserSecurity +
                    "&payState=Paid" +
                    "&pageNumber=" + this.currIndex + "&pageSize=10";
                //var url = "data/bills.json";
                PublicService.getListByURL(url).success(function (data) {
	                	if(data.result == '2'){ //token验证失败
	                		if(this.isIOS == "true"){
	                            PublicService.sendCommand("getBillList",PublicService.json2str(data));
	                		}else{
	                			client.getBillList(PublicService.json2str(data));
	                		}
	                	}else{
	                		if(data.result == '1'){
	                			  this.busy = false;
	                              var items = data.datas.result;
	                              for (var i = 0; i < items.length; i++) {
	                                  items[i].createDate = items[i].parkingOrderCreateTime.substring(0,10) ;//显示在每条账单的头部时间
	                            	  this.items.push(items[i]);
	                              }
	                		}else{
	                			this.tipTxt = '没有更多内容了！'
	                    		this.busy = false;
	                    		this.currIndex--;
	                		}
	                	}
                    }.bind(this))
                    .error(function (msg) {
                        this.busy = false;
                        if(this.isIOS == "true"){
                        	 PublicService.sendCommand("timeOut","timeOut");
                        }else{
                        	client.getBillList("timeOut");
                        }
                        console.log(msg);
                    });
            };
            return Reddit;
        })

        .controller('ctrlBillsNopaid', function ($scope, $location, PublicService) {


            $scope.parameters = $location.search();
            //http://localhost:63342/onlineParking_app_v1.0/app/index.html#/bills?key=123&id=46654
            //模拟临时文件
            var clientUserSecurity = $scope.parameters.clientUserSecurity;
            var parkingOrderClientUserId = $scope.parameters.parkingOrderClientUserId;

            var rs = [];
            this.currIndex = 1;

            var url = "/OnlineParking/rest/queryParkOrderLimit?" +
                "parkingOrderClientUserId=" + parkingOrderClientUserId +
                "&clientUserSecurity=" + clientUserSecurity +
                "&payState=NoPaid" +
                "&pageNumber=" + this.currIndex + "&pageSize=20";
            //var url = "data/billsNopaid.json";

            /*var url='/OnlineParking/rest/queryParkOrderLimit?' +
             'parkingOrderClientUserId=' + parkingOrderClientUserId +
             '&clientUserSecurity=' +clientUserSecurity+
             '&payState=NoPaid' +
             '&pageNumber=1&pageSize=20';
             */

            PublicService.getListByURL(url).success(function (data) {
                console.log(data.result)
                if (data.result != '0') {
                    var items = data.datas.result;
                    for (var i = 0; i < items.length; i++) {
                    	items[i].createDate = items[i].parkingOrderCreateTime.substring(0,10) ;//显示在每条账单的头部时间
                        rs.push(items[i]);
                    }

                }
            });


            $scope.ds = rs;

        })
        .factory('Reddit2', function ($http, PublicService) {
            //获取请求参数

        });

    /**
     * 用户信息反馈
     * @url   {string} app/index.html#/userCenter-feedBack
     * @param {string} clientUserSecurity 客户端用户令牌
     * @param {string} opinionUserId      用户id
     * @return {json}  result 0意见反馈失败 1意见反馈成功 2令牌不匹配重新登录
     */
    //clientUserSecurity=5b929b17fdcc4b588828dd3e86944c20&opinionUserId=8078748b218e4bcfbcd9468766109ab5
    var userCenterFeedBack = angular.module("UserCenterFeedBack", ["appOnline"]);

    userCenterFeedBack.controller("ctrlUserCenterFeedBack", function ($scope, $http, $location, PublicService, $window) {
        //获取请求参数
        $scope.parameters = $location.search();
        //从地址栏获取参数
        var clientUserSecurity = $scope.parameters.clientUserSecurity;
        var opinionUserId = $scope.parameters.opinionUserId;

        //与前台opinionBody绑定，并初始化
        $scope.formData = {'opinionBody': ""};
        $scope.wordNum = {'num': '0/255'};

        //统计字数
        $scope.checkText = function () {
            if ($scope.formData.opinionBody.length > 255) {
                $scope.formData.opinionBody = $scope.formData.opinionBody.substr(0, 255);
            }
            $scope.wordNum.num = $scope.formData.opinionBody.length + "/255";
        };

        //是否编辑过
        $scope.isEdit = function () {
            var oldWord = $("#opinionBody").val();
            if (oldWord == "" || oldWord == null) {
                return "false"; //未编辑过
            }
            return "true";//编辑过
        }

        $scope.submitFeedBack = function () {
            var opinionBody = $scope.formData.opinionBody;
            //判断输入是否为空
            if (opinionBody == "" || opinionBody == null) {
                alert("请输入您的意见");
                return;
            }
            //向后台传递的所有参数
            $scope.formData = {
                'clientUserSecurity': clientUserSecurity,
                'opinionUserId': opinionUserId,
                'opinionBody': opinionBody
            };
            console.log($scope.formData);
            //调用service.js中的方法，并传递url+params参数
            PublicService.getListByURL('/OnlineParking/rest/createOpinion', $scope.formData)
                .success(function (data) {
                    console.log(angular.toJson(data));
                    if ($scope.parameters.isIOS == "true") {
                        PublicService.sendCommand("feedBack", PublicService.json2str(data));
                    } else {
                        client.save(PublicService.json2str(data));
                    }
                })
                .error(function (data) {
                    //alert("提交意见失败,请重试");
                    client.save('timeOut');
                })
            ;
        };

        $scope.connectWebViewJavascriptBridge = function (callback) {
            if (window.WebViewJavascriptBridge) {
                callback(WebViewJavascriptBridge)
            } else {
                document.addEventListener('WebViewJavascriptBridgeReady', function () {
                    callback(WebViewJavascriptBridge)
                }, false)
            }
        }


        // 在init里面同样有一个function，这个function同样是用来接收Objective-C里面通过send方法发送的消息的，参数与OC里的send方法参数对应
        $scope.connectWebViewJavascriptBridge(function (bridge) {
            bridge.init(function (message, responseCallback) {
                if (message == "thisVCWantToPopToSuperVC") {
                    var data = $scope.isEdit();//true 为编辑过   false 为未编辑
                }
                responseCallback(data)
            })
        })

    });

    /**
     * 关于我们
     * @url app/index.html#/userCenter-aboutUs
     */
    var userCenterAboutUs = angular.module("UserCenterAboutUs", ["appOnline"]);
    userCenterAboutUs.controller("ctrlUserCenterAboutUs", function ($scope, $state, $window, $location, PublicService) {
        //获取请求参数
        $scope.parameters = $location.search();
        var isIOS = $scope.parameters.isIOS;
        
        //判断版本
        $scope.isNewVersion = $scope.parameters.isNewVersion ;
        $scope.version = $scope.parameters.version ;
        
        //注册协议
        $scope.toSoftwareAgree = function () {
            if (isIOS == "true") {//ios
                var data = 'pushToRuanJianXuKeXieYiVC'; //软件许可服务
                PublicService.sendCommand("aboutus", data);
            } else {//android
                client.go('userCenter-softwareAgreement');
            }
        };
        //免责声明
        $scope.toSoftwareState = function () {
            if (isIOS == "true") {//ios
                var data = 'pushToMianZeShengMingVC';  //免责声明
                PublicService.sendCommand("aboutus", data);
            } else {//android
                client.go('userCenter-softwareStatement');
            }
        }
        
        //版本更新
        $scope.toUpdateSoftWare = function(){
        	if (isIOS == "true") {//ios
                var data = 'updateVersion';  //版本更新
                PublicService.sendCommand("updateVersion", data);
            } else {//android
                client.go('updateVersion');
            }
        }
        
        $scope.tell = function (strNo) {
            client.tell(strNo);
        };
        $scope.weixin = function () {
            client.weixin('test');
        };
    });
    /**
     * 软件协议
     * @url app/index.html#/userCenter-softwareAgreement
     */
    /**
     * 免责声明
     * @url app/index.html#/userCenter-softwareStatement
     */
    var userCenterSoftwareAgreement = angular.module("userCenterSoftwareAgreement", ["appOnline"]);
    userCenterSoftwareAgreement.controller("ctrlUserCenterSoftwareAgreement", function ($scope, $http, PublicService) {
    });


    /**
     * 个人中心-添加车辆
     * @url http://localhost:8080/OnlineParking/app/index.html#/userCenter-addCar
     * @parame{String}   clientUserCarPosition
     * @parame{String}   clientUserId
     * @parame{String}   clientUserSecurity
     * @return{json}     result 0、失败 ;1、成功  ;2、token验证失败  ;
     */

    /**
     * 个人中心-添加车辆IOS
     * @url http://localhost:8080/OnlineParking/app/index.html#/userCenter-addCarios
     * @parame{String}   clientUserCarPosition
     * @parame{String}   clientUserId
     * @parame{String}   clientUserSecurity
     * @return{json}     result 0、失败 ;1、成功  ;2、token验证失败  ;
     */
    var UserCenterAddCar = angular.module("UserCenterAddCar", ["appOnline"]);
    UserCenterAddCar.controller("ctrlUserCenterAddCar", ['$scope', '$http', '$location', 'PublicService', function ($scope, $http, $location, PublicService, $window) {

        var data = [
            {
                "code": "京A",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京B",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京C",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京D",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京E",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京F",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京G",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京H",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京J",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京K",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京L",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京M",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            },
            {
                "code": "京Y",
                "city": "北京",
                "province": "北京",
                "Pcode": "BJ"
            }, {
                "code": "津A",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津B",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津C",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津D",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津E",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津F",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津G",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "津H",
                "city": "天津",
                "province": "天津",
                "Pcode": "TJ"
            },
            {
                "code": "冀A",
                "city": "石家庄",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀B",
                "city": "唐山",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀C",
                "city": "秦皇岛",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀D",
                "city": "邯郸",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀E",
                "city": "邢台",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀F",
                "city": "保定",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀G",
                "city": "张家口",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀H",
                "city": "承德",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀J",
                "city": "沧州",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀R",
                "city": "廊坊",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀S",
                "city": "沧州",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "冀T",
                "city": "衡水",
                "province": "河北",
                "Pcode": "HB"
            },
            {
                "code": "沪A",
                "city": "上海",
                "province": "上海",
                "Pcode": "SH"
            },
            {
                "code": "沪B",
                "city": "上海",
                "province": "上海",
                "Pcode": "SH"
            },
            {
                "code": "沪C",
                "city": "上海",
                "province": "上海",
                "Pcode": "SH"
            },
            {
                "code": "沪D",
                "city": "上海",
                "province": "上海",
                "Pcode": "SH"
            },
            {
                "code": "沪R",
                "city": "崇明、长兴、横沙",
                "province": "上海",
                "Pcode": "SH"
            },
            {
                "code": "黑A",
                "city": "哈尔滨",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑B",
                "city": "齐齐哈尔",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑C",
                "city": "牡丹江",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑D",
                "city": "佳木斯",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑E",
                "city": "大庆",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑F",
                "city": "伊春",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑G",
                "city": "鸡西",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑H",
                "city": "鹤岗",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑J",
                "city": "双鸭山",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑K",
                "city": "七台河",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑L",
                "city": "松花江地区",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑M",
                "city": "绥化",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑N",
                "city": "黑河",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑P",
                "city": "大兴安岭地区",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "黑R",
                "city": "农垦系统",
                "province": "黑龙江",
                "Pcode": "HLJ"
            },
            {
                "code": "吉A",
                "city": "长春",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉B",
                "city": "吉林",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉C",
                "city": "四平",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉D",
                "city": "辽源",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉E",
                "city": "通化",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉F",
                "city": "白山",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉G",
                "city": "白城",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉H",
                "city": "延边朝鲜族自治州",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉J",
                "city": "松原",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "吉K",
                "city": "长白山",
                "province": "吉林",
                "Pcode": "JL"
            },
            {
                "code": "辽A",
                "city": "沈阳",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽B",
                "city": "大连",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽C",
                "city": "鞍山",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽D",
                "city": "抚顺",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽E",
                "city": "本溪",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽F",
                "city": "丹东",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽G",
                "city": "锦州",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽H",
                "city": "营口",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽J",
                "city": "阜新",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽K",
                "city": "辽阳",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽L",
                "city": "盘锦",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽M",
                "city": "铁岭",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽N",
                "city": "朝阳",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "辽P",
                "city": "葫芦岛",
                "province": "辽宁",
                "Pcode": "LN"
            },
            {
                "code": "渝A",
                "city": "重庆区（江南）",
                "province": "重庆",
                "Pcode": "ZQ"
            },
            {
                "code": "渝B",
                "city": "重庆区（江北）",
                "province": "重庆",
                "Pcode": "ZQ"
            },
            {
                "code": "渝C",
                "city": "永川区",
                "province": "重庆",
                "Pcode": "ZQ"
            },
            {
                "code": "渝F",
                "city": "万州区",
                "province": "重庆",
                "Pcode": "ZQ"
            },
            {
                "code": "渝G",
                "city": "涪陵区",
                "province": "重庆",
                "Pcode": "ZQ"
            },
            {
                "code": "渝H",
                "city": "黔江区",
                "province": "重庆",
                "Pcode": "ZQ"
            },

            {
                "code": "皖A",
                "city": "合肥",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖B",
                "city": "芜湖",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖C",
                "city": "蚌埠",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖D",
                "city": "淮南",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖E",
                "city": "马鞍山",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖F",
                "city": "淮北",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖G",
                "city": "铜陵",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖H",
                "city": "安庆",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖J",
                "city": "黄山",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖K",
                "city": "阜阳",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖L",
                "city": "宿州",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖M",
                "city": "滁州",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖N",
                "city": "六安",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖P",
                "city": "宣城",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖Q",
                "city": "巢湖",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖R",
                "city": "池州",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "皖S",
                "city": "亳州",
                "province": "安徽",
                "Pcode": "AH"
            },
            {
                "code": "苏A",
                "city": "南京",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏B",
                "city": "无锡",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏C",
                "city": "徐州",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏D",
                "city": "常州",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏E",
                "city": "苏州",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏F",
                "city": "南通",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏G",
                "city": "连云港",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏H",
                "city": "淮安",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏J",
                "city": "盐城",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏K",
                "city": "扬州",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏L",
                "city": "镇江",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏M",
                "city": "泰州",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "苏N",
                "city": "宿迁",
                "province": "江苏",
                "Pcode": "JS"
            },
            {
                "code": "鄂A",
                "city": "武汉",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂B",
                "city": "黄石",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂C",
                "city": "十堰",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂D",
                "city": "荆州",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂E",
                "city": "宜昌",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂F",
                "city": "襄樊",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂G",
                "city": "鄂州",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂H",
                "city": "荆门 ",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂J",
                "city": "黄冈",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂K",
                "city": "孝感",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂L",
                "city": "咸宁",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂M",
                "city": "仙桃",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂N",
                "city": "潜江",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂P",
                "city": "神农架林区",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂Q",
                "city": "恩施土家族苗族自治州",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂R",
                "city": "天门",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "鄂S",
                "city": "随州",
                "province": "湖北",
                "Pcode": "HB"
            },
            {
                "code": "晋A",
                "city": "太原",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋B",
                "city": "大同",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋C",
                "city": "阳泉",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋D",
                "city": "长治",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋E",
                "city": "晋城",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋F",
                "city": "朔州",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋H",
                "city": "忻州",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋J",
                "city": "吕梁地区",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋K",
                "city": "晋中",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋L",
                "city": "临汾",
                "province": "山西",
                "Pcode": "SX"
            },
            {
                "code": "晋M",
                "city": "运城",
                "province": "山西",
                "Pcode": "SX"
            },

            {
                "code": "粤A",
                "city": "广州",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤B",
                "city": "深圳",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤C",
                "city": "珠海",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤D",
                "city": "汕头",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤E",
                "city": "佛山",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤F",
                "city": "韶关",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤G",
                "city": "湛江",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤H",
                "city": "肇庆",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤J",
                "city": "江门",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤K",
                "city": "茂名",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤L",
                "city": "惠州",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤M",
                "city": "梅州",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤N",
                "city": "汕尾",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤P",
                "city": "河源",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤Q",
                "city": "阳江",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤R",
                "city": "清远",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤S",
                "city": "东莞",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤T",
                "city": "中山",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤U",
                "city": "潮州",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤V",
                "city": "揭阳",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤W",
                "city": "云浮",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤X",
                "city": "顺德区",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤Y",
                "city": "南海区",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "粤Z",
                "city": "港澳进入内地车辆",
                "province": "广东",
                "Pcode": "GD"
            },
            {
                "code": "宁A",
                "city": "银川",
                "province": "宁夏",
                "Pcode": "NX"
            },
            {
                "code": "宁B",
                "city": "石嘴山",
                "province": "宁夏",
                "Pcode": "NX"
            },
            {
                "code": "宁C",
                "city": "银南",
                "province": "宁夏",
                "Pcode": "NX"
            },
            {
                "code": "宁D",
                "city": "固原",
                "province": "宁夏",
                "Pcode": "NX"
            },
            {
                "code": "宁E",
                "city": "中卫",
                "province": "宁夏",
                "Pcode": "NX"
            },

            {
                "code": "豫A",
                "city": "郑州",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫B",
                "city": "开封",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫C",
                "city": "洛阳",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫D",
                "city": "平顶山",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫E",
                "city": "安阳",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫F",
                "city": "鹤壁",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫G",
                "city": "新乡",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫H",
                "city": "焦作",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫J",
                "city": "濮阳",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫K",
                "city": "许昌",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫L",
                "city": "漯河",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫M",
                "city": "三门峡",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫N",
                "city": "商丘",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫P",
                "city": "周口",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫Q",
                "city": "驻马店",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫R",
                "city": "南阳",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫S",
                "city": "信阳",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "豫U",
                "city": "济源",
                "province": "河南",
                "Pcode": "HN"
            },
            {
                "code": "鲁A ",
                "city": "济南",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁B",
                "city": "青岛",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁C",
                "city": "淄博",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁D",
                "city": "枣庄",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁E",
                "city": "东营",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁F",
                "city": "烟台",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁G",
                "city": "潍坊",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁H",
                "city": "济宁",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁J",
                "city": "泰安",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁K",
                "city": "威海",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁L",
                "city": "日照",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁M",
                "city": "滨州",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁N",
                "city": "德州",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁P",
                "city": "聊城",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁Q",
                "city": "临沂",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁R",
                "city": "菏泽",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁S",
                "city": "莱芜",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁U",
                "city": "青岛增补",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁V",
                "city": "潍坊增补",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "鲁Y",
                "city": "烟台",
                "province": "山东",
                "Pcode": "SD"
            },
            {
                "code": "浙A",
                "city": "杭州",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙B",
                "city": "宁波",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙C",
                "city": "温州",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙D",
                "city": "绍兴",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙E",
                "city": "湖州",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙F",
                "city": "嘉兴",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙G",
                "city": "金华",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙H",
                "city": "衢州",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙J",
                "city": "台州",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙K",
                "city": "丽水",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "浙L",
                "city": "舟山",
                "province": "浙江",
                "Pcode": "ZJ"
            },
            {
                "code": "桂A",
                "city": "南宁",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂B",
                "city": "柳州",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂C",
                "city": "桂林",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂D",
                "city": "梧州",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂E",
                "city": "北海",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂F",
                "city": "崇左",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂G",
                "city": "来宾",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂H",
                "city": "桂林地区",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂J",
                "city": "贺州",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂K",
                "city": "玉林",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂L",
                "city": "百色",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂M",
                "city": "河池",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂N",
                "city": "钦州",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂P",
                "city": "防城港",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "桂R",
                "city": "贵港",
                "province": "广西",
                "Pcode": "GX"
            },
            {
                "code": "蒙A",
                "city": "呼和浩特",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙B",
                "city": "包头",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙C",
                "city": "乌海",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙D",
                "city": "赤峰",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙E",
                "city": "呼伦贝尔 ",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙F",
                "city": "兴安盟",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙G",
                "city": "通辽",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙H",
                "city": "锡林郭勒盟",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙J",
                "city": "乌兰察布盟",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙K",
                "city": "鄂尔多斯 ",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙L",
                "city": "巴彦淖尔盟",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "蒙M　",
                "city": "　阿拉善盟",
                "province": "内蒙古",
                "Pcode": "NMG"
            },
            {
                "code": "闽A",
                "city": "福州",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽B",
                "city": "莆田",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽C",
                "city": "泉州",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽D",
                "city": "厦门",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽E",
                "city": "漳州",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽F",
                "city": "龙岩",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽G",
                "city": "三明",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽H",
                "city": "南平",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽J",
                "city": "宁德",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "闽K",
                "city": "直系统",
                "province": "福建",
                "Pcode": "FJ"
            },
            {
                "code": "川A",
                "city": "成都",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川B",
                "city": "绵阳",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川C",
                "city": "自贡",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川D",
                "city": "攀枝花",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川E",
                "city": "泸州",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川F",
                "city": "德阳",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川H",
                "city": "广元",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川J",
                "city": "遂宁",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川K",
                "city": "内江",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川L",
                "city": "乐山",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川M",
                "city": "资阳",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川Q",
                "city": "宜宾",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川R",
                "city": "南充",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川S",
                "city": "达州",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川T",
                "city": "雅安",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川U",
                "city": "阿坝藏族羌族自治州",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川V",
                "city": "甘孜藏族自治州",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川W",
                "city": "凉山彝族自治州",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川X",
                "city": "广安",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川Y",
                "city": "巴中",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "川Z",
                "city": "眉山",
                "province": "四川",
                "Pcode": "SC"
            },
            {
                "code": "云A",
                "city": "昆明",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云A-V",
                "city": "东川",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云C",
                "city": "昭通",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云D",
                "city": "曲靖",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云E",
                "city": "楚雄彝族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云F",
                "city": "玉溪",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云G",
                "city": "红河哈尼族彝族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云H",
                "city": "文山壮族苗族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云J",
                "city": "思茅",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云K",
                "city": "西双版纳傣族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云L",
                "city": "大理白族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云M",
                "city": "保山",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云N",
                "city": "德宏傣族景颇族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云P",
                "city": "丽江",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云Q",
                "city": "怒江傈僳族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云R",
                "city": "迪庆藏族自治州",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "云S",
                "city": "临沧地区",
                "province": "云南",
                "Pcode": "YN"
            },
            {
                "code": "湘A ",
                "city": "长沙",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘B",
                "city": "株洲",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘C",
                "city": "湘潭",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘D",
                "city": "衡阳",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘E",
                "city": "邵阳",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘F",
                "city": "岳阳",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘G",
                "city": "张家界",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘H",
                "city": "益阳",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘J",
                "city": "常德",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘K",
                "city": "娄底",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘L",
                "city": "郴州",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘M",
                "city": "永州",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘N",
                "city": "怀化",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "湘U",
                "city": "湘西土家族苗族自治州",
                "province": "湖南",
                "Pcode": "HN"
            },
            {
                "code": "新A",
                "city": "乌鲁木齐",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新B",
                "city": "昌吉回族自治州",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新C",
                "city": "石河子",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新D",
                "city": "奎屯",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新E",
                "city": "博尔塔拉蒙古自治州",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新F",
                "city": "伊犁哈萨克自治州直辖县",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新G",
                "city": "塔城",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新H",
                "city": "阿勒泰",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新J",
                "city": "克拉玛依",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新K",
                "city": "吐鲁番",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新L",
                "city": "哈密",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新M",
                "city": "巴音郭愣蒙古自治州",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新N",
                "city": "阿克苏",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新P",
                "city": "克孜勒苏柯尔克孜自治州",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新Q",
                "city": "喀什",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "新R",
                "city": "和田",
                "province": "新疆",
                "Pcode": "XJ"
            },
            {
                "code": "赣A",
                "city": "南昌",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣B",
                "city": "赣州",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣C",
                "city": "宜春",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣D",
                "city": "吉安",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣E",
                "city": "上饶",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣F",
                "city": "抚州",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣G",
                "city": "九江",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣H",
                "city": "景德镇",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣J",
                "city": "萍乡",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣K",
                "city": "新余",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣L",
                "city": "鹰潭",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "赣M",
                "city": "南昌,直系统",
                "province": "江西",
                "Pcode": "JX"
            },
            {
                "code": "甘A",
                "city": "兰州",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘B",
                "city": "嘉峪关",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘C",
                "city": "金昌",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘D",
                "city": "白银",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘E",
                "city": "天水",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘F",
                "city": "酒泉",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘G",
                "city": "张掖",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘H",
                "city": "武威",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘J",
                "city": "定西",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘K",
                "city": "陇南",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘L",
                "city": "平凉",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘M",
                "city": "庆阳",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘N",
                "city": "临夏回族自治州",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "甘P",
                "city": "甘南藏族自治州",
                "province": "甘肃",
                "Pcode": "GS"
            },
            {
                "code": "陕A",
                "city": "西安",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕B",
                "city": "铜川",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕C",
                "city": "宝鸡",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕D",
                "city": "咸阳",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕E",
                "city": "渭南",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕F",
                "city": "汉中",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕G",
                "city": "安康",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕H",
                "city": "商洛",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕J",
                "city": "延安",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕K",
                "city": "榆林",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "陕V",
                "city": "杨凌高新农业示范区",
                "province": "陕西",
                "Pcode": "SX"
            },
            {
                "code": "贵A",
                "city": "贵阳",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵B",
                "city": "六盘水",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵C",
                "city": "遵义",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵D",
                "city": "铜仁",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵E",
                "city": "黔西南布依族苗族自治州",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵F",
                "city": "毕节",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵G",
                "city": "安顺",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵H",
                "city": "黔东南苗族侗族自治州",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "贵J",
                "city": "黔南布依族苗族自治州",
                "province": "贵州",
                "Pcode": "GZ"
            },
            {
                "code": "青A",
                "city": "西宁",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青B",
                "city": "海东",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青C",
                "city": "海北藏族自治州",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青D",
                "city": "黄南藏族自治州",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青E",
                "city": "藏族自治州",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青F",
                "city": "果洛藏族自治州",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青G",
                "city": "玉树藏族自治州",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "青H",
                "city": "海西蒙古族藏族自治州",
                "province": "青海",
                "Pcode": "QH"
            },
            {
                "code": "藏A",
                "city": "拉萨",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏B",
                "city": "昌都地区",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏C",
                "city": "山南地区",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏D",
                "city": "日喀则地区",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏E",
                "city": "那曲地区",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏F",
                "city": "阿里地区",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏G",
                "city": "林芝地区",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏H",
                "city": "天全县车辆管理所",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "藏J",
                "city": "格尔木车辆管理所",
                "province": "西藏",
                "Pcode": "XC"
            },
            {
                "code": "琼A",
                "city": "海口",
                "province": "海南",
                "Pcode": "HN"
            },
            {
                "code": "琼B",
                "city": "三亚",
                "province": "海南",
                "Pcode": "HN"
            },
            {
                "code": "琼C",
                "city": "琼海",
                "province": "海南",
                "Pcode": "HN"
            },
            {
                "code": "琼D",
                "city": "五指山",
                "province": "海南",
                "Pcode": "HN"
            },
            {
                "code": "琼E",
                "city": "洋浦开发区",
                "province": "海南",
                "Pcode": "HN"
            }
        ];

        //从A到Z的数组
        $scope.zm = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

        var rs = [],
            jc = '',
            obj = '';


        for (var i = 0; i < data.length; i++) {
            //console.log(i);
            var temJc = data[i]['code'].substr(0, 1);
            var dm = data[i]['code'].substr(1, 1);
            if (temJc != jc) {//新建对象
                var obj = {};
                obj['jc'] = temJc;
                obj['dm'] = [dm];
                jc = temJc;
                rs.push(obj);
            }
            else {
                obj['dm'].push(dm)
            }
        }
        $scope.treeList = rs;
        //console.log($scope.treeList);
        /*车牌号1-5*/
        $scope.carNoFir = "";
        $scope.carNoSec = "";
        $scope.carNoThir = "";
        $scope.carNoFor = "";
        $scope.carNoFiv = "";
        //从地址栏获取参数
        $scope.parameters = $location.search();
        //参数
        $scope.data = {
            "clientUserSecurity": $scope.parameters.clientUserSecurity || '',
            "clientUserId": $scope.parameters.clientUserId || '',
            "clientUserCarPosition": $scope.parameters.clientUserCarPosition || '',
            "clientUserCarNo": ''
        };
        $scope.clientUserCarNo = {"clientUserCarNo": ''};
        $scope.getCarNo = function () {
            //车牌号拼接
            var carNumber = $("#carNo").text() +
                $scope.virtualKeybordData.join('');

            $scope.data.clientUserCarNo = carNumber;
        }
        //绑定保存事件
        /* $scope.saveCarNo = function () {
         this.getCarNo();

         client.save($scope.clientUserCarNo.clientUserCarNo);
         }*/
        //绑定保存事件IOS
        $scope.saveCarNoIos = function () {
            $scope.isBtnDisabled = true;
            $scope.getCarNo();
//            PublicService.getListByURL('/OnlineParking/rest/hasUserCarNo', $scope.data.clientUserCarNo)
//                .success(function (data) { //result 0、不存在  1、存在
//                    if (data.result == "0") {

                    	
                    	
                        PublicService.getListByURL('/OnlineParking/rest/insertUserCar', $scope.data)
                            .success(function (data) { //result 0、失败 ;1、成功  ;2、token验证失败  ;

                                if ($scope.parameters.isIOS == "true") {
                                    PublicService.sendCommand("addCarNo", PublicService.json2str(data));
                                } else {
                                    client.saveCarNo(PublicService.json2str(data));
                                }
                            })
                            .error(function () {
                                $scope.isBtnDisabled = false;
                                if ($scope.parameters.isIOS == "true") {
                                    PublicService.sendCommand("addCarNo", "timeOut");
                                } else {
                                    client.saveCarNo("timeOut");
                                }
                            });
                        
//                        
//                    } else if (data.result == "1") {
//                        $scope.isBtnDisabled = false;
//                        if ($scope.parameters.isIOS == "true") {
//                            PublicService.sendCommand("addCarNo", PublicService.json2str(data));
//                        } else {
//                            client.isExist(PublicService.json2str(data));
//                            //alert('车牌已存在，不能重复添加！');
//                        }
//                    }
//                })
//                .error(function () {
//                    $scope.isBtnDisabled = false;
//                    if ($scope.parameters.isIOS == "true") {
//                        PublicService.sendCommand("addCarNo", "timeOut");
//                    } else {
//                        client.isExist("timeOut");
//                    }
//                });
        }

        //键盘数据对象
        $scope.virtualKeybordData = [];
        $scope.indexCurrInput = 0;
        $scope.isUserClick = false;

        /*    $scope.setIndexCurrInput = function (index) {
         $scope.indexCurrInput = index;
         $scope.isUserClick=true;
         alert(0);
         }*/


        $scope.isShowKeyBord = false;
        $scope.setCurrIndex = function (index) {
            $scope.indexCurrInput = $scope.indexCurrInput ? index : 0;
            console.log($scope.indexCurrInput)
            //$scope.isUserClick = true;
        }
        $scope.isBtnDisabled = true;
        $scope.setBtnType = function () {
            var ok = 0;
            if ($scope.virtualKeybordData.length == 5) {
                angular.forEach($scope.virtualKeybordData, function (item) {
                    //item!='' && ok+1;
                    if (item != "") {
                        ok += 1;
                    }
                });
            }
            if (ok >= 5) {
                $scope.isBtnDisabled = false
            } else {
                $scope.isBtnDisabled = true
            }
        }

    }]);
    UserCenterAddCar.directive('virtualKeybord', function () {
        return {
            restrict: "A",
            templateUrl: 'tpls/virtualKeybord.html',
            controller: 'ctrlUserCenterAddCar',
            link: function ($scope, el, attr) {
                //数字和字母皱键
                el.find('li').on('click',
                    function () {
                        var nowTxt = $(this).text();
                        $scope.$apply(function () {
                            $scope.virtualKeybordData[$scope.indexCurrInput] = nowTxt;
                            if ($scope.indexCurrInput + 1 <= 4) {
                                ++$scope.indexCurrInput;
                            } else {
                                $scope.indexCurrInput = 4;
                            }
                            var rs = 0;
                            for (var i = 0; i < $scope.virtualKeybordData.length; i++) {
                                //console.log($scope.virtualKeybordData[i]);
                                ($scope.virtualKeybordData[i] != '') && ++rs;
                            }
                            //(rs < 5) && ($scope.isUserClick = true) || ($scope.isUserClick = false);
                            $scope.setBtnType();
                        });
                        return false;
                    });
                //删除
                el.find('.del').on('click',
                    function () {
                        $scope.$apply(function () {
                            $scope.virtualKeybordData[$scope.indexCurrInput] = '';
                            if ($scope.indexCurrInput - 1 < 0) {
                                $scope.indexCurrInput = 0;
                            } else {
                                --$scope.indexCurrInput
                            }
                            $scope.setBtnType();
                        });
                        return false;
                    });


            }

        }
    });

    /**
     * 消息详情
     * @url/OnlineParking/app/index.html#/message-detail
     * @parame {String}  msgName 消息标题
     * @parame {String}  msgBody 内容
     * @parame {String}  msgBodyImgUrl    图片路径
     * @parame {String}  msgSendTime 发送时间
     * @parame {String}  msgSendName 发送人
     */

    var messageDetail = angular.module("MessageDetail", ["appOnline"]);
    messageDetail.controller("ctrlMessageDetail", function ($scope, $http, $location, PublicService, $window) {
        $scope.parameters = $location.search();
        $scope.msgName = $scope.parameters.msgName; //消息标题
        $scope.msgBody = $scope.parameters.msgBody; //内容
        $scope.msgBodyImgUrl = $scope.parameters.msgBodyImgUrl; //图片路径
        $scope.msgSendTime = $scope.parameters.msgSendTime; //发送时间
        $scope.msgSendName = $scope.parameters.msgSendName; //发送人
        $scope.show = true;
        if ($scope.msgBodyImgUrl == "") {
            $scope.show = false;
        }
    });


})();