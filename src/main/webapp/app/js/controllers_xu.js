(function () {
    angular.module('UserCenterInfo', [])
        .controller('userCenterInfoCtrl', userCenterInfoCtrl);

    /**
     * 个人信息
     * @controller
     * @url   {string} app/index.html#/userCenter-info
     * @param {string} clientUserCellphone 手机号
     * @param {string} clientUserNickName  用户昵称
     * @param {string} clientUserSex       性别
     * @param {string} clientUserBirthday  出生日期
     * @param {string} clientUserSecurity  token
     * @return
     */
    userCenterInfoCtrl.$inject = ['$scope', '$http', '$location', '$window', 'PublicService'];
    function userCenterInfoCtrl($scope, $http, $location, $window, PublicService) {
        var params = $location.search();
        //clientUserNickName=张三&suerSex=男&userBirthday=&userEmail=&isUserWoman=false&clientUserCellphone=13521515002&clientUserSecurity=5b929b17fdcc4b588828dd3e86944c20

        //定义对象

        //clientUserCellphone=13521515002&clientUserNickName=twt&clientUserSex=1&clientUserBirthday=2015年01月01日&clientUserSecurity=5b929b17fdcc4b588828dd3e86944c20
        $scope.userInfo = {
            clientUserNickName: params.clientUserNickName || '',
            clientUserSex: params.clientUserSex == '0' && '女' || '男',
            clientUserBirthday: params.clientUserBirthday || '',
            isUserWoman: params.clientUserSex == '0' && true || false,
            clientUserCellphone: params.clientUserCellphone,//
            clientUserSecurity: params.clientUserSecurity,
            isIOS: params.isIOS
        }
        console.log($scope.userInfo)
        //输出生日到view
        $scope.userInfo.clientUserBirthday && $("#appDate").val($scope.userInfo.clientUserBirthday);
        //console.log($scope.userInfo.clientUserSex);

        //测试方法
        $scope.getVal = function () {
            console.log($scope.userInfo);
        }

        $scope.getDate = function () {
            var date = $("#appDate").val();
            $scope.userInfo.clientUserBirthday = date;
            //console.log($scope.userInfo.clientUserBirthday);
        }

        $scope.setSex = function (txt) {
            if (txt === '女') {
                $scope.userInfo.isUserWoman = true;
            } else {
                $scope.userInfo.isUserWoman = false;
            }
        }
        $scope.saveNickName = function () {
            $scope.save(1)
        }
        //当性别发生变化时保存
        $scope.$watch('userInfo.isUserWoman', function (newV, oldV) {
            oldV !== newV &&
            $scope.save(2)
        })
        //当生日发生变化时保存
        $scope.$watch('userInfo.clientUserBirthday', function (newV, oldV) {
            oldV !== newV &&
            $scope.save(3)
        })


        //
        /**
         * @保存updateUser
         * param saveType 1：修改用户昵称 2：修改性别  3：修改生日
         * */
        $scope.save = function (saveType) {
            /*this.getDate();
             //转换参数
             //var upUserInfo=PublicService.cloneObj($scope.userInfo);
             var upUserInfo = angular.copy($scope.userInfo);

             (upUserInfo.isUserWoman == false) && (upUserInfo.clientUserSex = 1) || (upUserInfo.clientUserSex = 0);
             //出生日期
             var temDate = upUserInfo.clientUserBirthday;
             //upUserInfo.clientUserBirthday=temDate.substr(0,4)+'年'+temDate.substr(5,2)+'月'+temDate.substr(8,2)+'日';
             upUserInfo.clientUserBirthday = temDate;
             //console.log(upUserInfo);
             //var url = 'http://118.194.244.20:9999/OnlineParking/rest/updateUser';*/

            var upUserInfo = {
                clientUserCellphone: $scope.userInfo.clientUserCellphone,
                clientUserSecurity: $scope.userInfo.clientUserSecurity
            };
            switch (saveType) {
                case 1://昵称
                    upUserInfo.clientUserNickName = $scope.userInfo.clientUserNickName;
                    break;
                case 2://性别
                    upUserInfo.clientUserSex = $scope.userInfo.isUserWoman ? 0 : 1;
                    break;
                case 3://生日
                    upUserInfo.clientUserBirthday = $scope.userInfo.clientUserBirthday;
                    break;
                default:
                    break;
            }

            var url = '/OnlineParking/rest/updateUser';
            PublicService.getListByURL(url, upUserInfo
                )
                .success(
                    function (data) {
                        //alert('保存成功！');
                        //upUserInfo['result'] = data.result;


                        //data.saveType=saveType;
                        console.log(data)
                        if ($scope.userInfo.isIOS == "true") {
                            PublicService.sendCommand("personalEdit", PublicService.json2str(data));
                        } else {
                            client.save(PublicService.json2str(data));
                        }
                    }
                )
                .error(
                    function () {
                        alert('保存失败，请重试。');
                    }
                );
        }

        //跳转编辑昵称页面
        $scope.editNickName = function(){
            console.log($scope.userInfo.isIOS)
            if ($scope.userInfo.isIOS == "true") {
                PublicService.sendCommand("personalEdit", "personalEdit");
            } else {
                client.editNickName()
            }

        }

        //android控制页面是否可编辑
        $scope.isEdit = true;
        $('#selectSex').attr('data-target', '#chooseSex');
        /*$scope.androidEdit = function (strBool) {
         if (strBool === 'true') {
         $scope.isEdit = true;
         $('#selectSex').attr('data-target', '#chooseSex');
         } else {
         $scope.isEdit = false;
         $('#selectSex').attr('data-target', '');
         $scope.save();
         }
         }*/

//        $scope.connectWebViewJavascriptBridge = function (callback) {
//            if (window.WebViewJavascriptBridge) {
//                callback(WebViewJavascriptBridge)
//            } else {
//                document.addEventListener('WebViewJavascriptBridgeReady', function () {
//                    callback(WebViewJavascriptBridge)
//                }, false)
//            }
//        }


        // 在init里面同样有一个function，这个function同样是用来接收Objective-C里面通过send方法发送的消息的，参数与OC里的send方法参数对应
//        $scope.connectWebViewJavascriptBridge(function (bridge) {
//            bridge.init(function (message, responseCallback) {
//                androidEdit(message);
//                responseCallback(data)
//            })
//        })


        $scope.testEdit = function (str) {
            alert(str);
            //$scope.isEdit=!$scope.isEdit;
            $scope.androidEdit(str);
        }
    }


    angular.module('appOnline')
        /**
         * 系统设置
         * @controller
         * @url   {string} app/index.html#/userCenter-systemSet
         * @return
         */
        .controller('systemSetCtr', ['$scope', '$location', 'PublicService', function ($scope, $location, PublicService) {

            var isIOS = $location.search().isIOS;

            //离线地图
            $scope.getMap = function () {
                if (isIOS == "true") {
                    PublicService.sendCommand("sendCommand", "downLoadMapVC");
                } else {
                    client.getMap();
                }
            }
            //自动支付
            $scope.autoPay = function () {
                if (isIOS == "true") {
                    PublicService.sendCommand("sendCommand", "autoPayVC");
                } else {
                    client.autoPay();
                }
            }
            //意见反馈
            $scope.feedBack = function () {
                if (isIOS == "true") {
                    PublicService.sendCommand("sendCommand", "ideaBackVC");
                } else {
                    client.feedBack();
                }
            }
            //关于我们
            $scope.aboutUs = function () {
                if (isIOS == "true") {
                    PublicService.sendCommand("sendCommand", "aboutUsVC");
                } else {
                    client.aboutUs();
                }
            }
            //退出
            $scope.quit = function () {
                if (isIOS == "true") {
                    PublicService.sendCommand("sendCommand", "exitBtnAction");
                } else {
                    client.quit();
                }
            }
        }])

        /**
         * 个人中心列表
         * @controller
         * @url   {string} app/index.html#/userCenter-userInfo-list
         * @return
         */

        .controller('userInfoListCtr', ['$scope', '$location', 'PublicService', function ($scope, $location, PublicService) {
            //个人信息
            $scope.userInfo = function () {
                if ($location.search().isIOS == "true") {
                    PublicService.sendCommand("usercenterInfo", "pushPerEditVC");
                } else {
                    client.userInfo();
                }
            }
            //修改手机号
            $scope.editPoneNum = function () {
                if ($location.search().isIOS == "true") {
                    PublicService.sendCommand("usercenterInfo", "pushPhonrVC");
                } else {
                    client.editPoneNum();
                }
            }
        }])


        /**
         * 错误页
         * @controller
         * @url   {string} app/index.html#/error
         * @return
         */
        .controller('errorCtr', ['$scope', function ($scope) {
            //重新加载
            $scope.reload = function () {
                client.reload();
            }
        }])

        /**
         * 收费明细
         * @controller
         * @param  {string} parkingOrderParkingInfoId
         * @url    {string} app/index.html#/charge-detail
         * @return
         */
        .controller('chargeDetailCtr', ['$scope', '$location', 'PublicService', function ($scope, $location, PublicService) {
            this.parkingOrderParkingInfoId = $location.search().parkingOrderParkingInfoId;
            var url = '/OnlineParking/rest/getChargingStandardsListByParkingInfoId?parkingInfoId=' + this.parkingOrderParkingInfoId;
            PublicService.getListByURL(url).success(function (data) {
                //console.log(data)
                $scope.chargeData = data.datas;
            });

        }])


        /**
         *自动支付
         * @controller
         * @param  {string} parkingOrderClientUserId
         *                  clientUserSecurity
         * @url    {string} app/index.html#/userCenter-systemSet-autoPay
         * @return
         * */
        .controller('setAutoPayCtrl', ['$scope', function ($scope) {
            $scope.isAutoPaid = false;
            $scope.togglePaid = function () {
                $scope.isAutoPaid = !$scope.isAutoPaid;
                console.log($scope.isAutoPaid)


            }

        }])


        /**
         *消息列表
         * @controller messageListCtrl
         * @param      {string} parkingOrderClientUserId
         *                      clientUserSecurity
         * @url        {string} app/index.html#/message-list
         * @return
         * */
        .controller('messageListCtrl', ['$scope', 'PublicService', '$timeout', '$window', function ($scope, PublicService, $timeout, $window) {

            $scope.data =
                [
                    {
                        msgId: 1,
                        msgName: '信息标题',
                        msgBody: '内容内容内容内容内容内容',
                        msgIsOpen: true,
                        msgBodyImgUrl: '',
                        msgSendTime: '2015-06-06 12:12:12',

                    },
                    {
                        msgId: 1,
                        msgName: '信息标题',
                        msgBody: '内容内容内容内容内容内容',
                        msgIsOpen: false,
                        msgBodyImgUrl: '',
                        msgSendTime: '2015-06-06 12:12:12'
                    }
                ];

            $scope.dataMessageList;

            $scope.getMsgData = function (ds) {
                alert(ds);
                ds = angular.toJson(ds);

                $scope.dataMessageList = ds;
            }

            $scope.goDetail = function (item) {
                client.goDetail(PublicService.json2str(item));
            }


        }])


        /**
         *车辆列表
         *  @controller
         *    @parame clientUserId
         *    @parame clientUserSecurity
         *    @parame    {string}clientUserCarActiveMark   用户车辆激活状态 disable关  enable开
         *    @parame {数组} setAlarmTime 提醒时间
         *    @parame clientUserCarNo 车牌号
         *  @param  {string} parkingOrderClientUserId
         *                  clientUserSecurity
         *  @url    {string} app/index.html#/userCenter_car_list
         *  @return
         *  */
        .controller('carListCtrl', ['$scope', 'PublicService', '$location', function ($scope, PublicService, $location) {
            var _this = this;
            var params = $location.search();
            var url = "/OnlineParking/rest/selectUserCar?" +
                "clientUserId=" + params.clientUserId +
                "&clientUserSecurity=" + params.clientUserSecurity;
            //模拟数据
            //url = 'data/carList.json';

            $scope.cars = [];
            $scope.showDel = false;

            //获取初始化时间的数组
            $scope.getAlarmTime = function (str) {
                var alarmTime = [];
                if (str != "") {
                    alarmTime[0] = str.substring(0, 2);
                    alarmTime[1] = str.substring(2, 4);
                }
                return alarmTime;
            }

            _this.setCarRemindTime = function (data) {
                for (var i = 0; i < data.datas.length; i++) {
                    data.datas[i].isIOS = params.isIOS;
                    if (data.datas[i].clientUserCarNo == params.clientUserCarNo) {
                        data.datas[i].remindTime = $scope.getAlarmTime(params.setAlarmTime);
                    } else {
                        data.datas[i].remindTime = '';
                    }
                }
                return data || {};
            }

            PublicService.getListByURL(url).success(function (data) {
                    _this.setCarRemindTime(data);
                    if (data.result == "2") {
                        if (params.isIOS == "true") {//token验证失败
                            PublicService.sendCommand("getList", PublicService.json2str(data));
                        } else {
                            client.getList(PublicService.json2str(data));
                        }
                    }
                    else {
                        $scope.cars = data;
                    }
                })
                .error(function () {
                    if (params.isIOS == "true") {
                        PublicService.sendCommand('getList', 'timeOut');
                    } else {
                        client.getList('timeOut');
                    }
                })

            //切换车辆是否可用
            $scope.changeState = function (car) {
                var url =
                    "/OnlineParking/rest/upUserCarActiveMark?" +
                    "carManageId=" + car.carManageId +
                    "&clientUserId=" + params.clientUserId +
                    "&clientUserSecurity=" + params.clientUserSecurity +
                    "&clientUserCarActiveMark=" + (car.clientUserCarActiveMark == 'disable' ? 'enable' : 'disable');

                PublicService.getListByURL(url)
                    .success(function (data) {
                        if (data.result == "1") { //成功
                            car.clientUserCarActiveMark == 'disable' ? car.clientUserCarActiveMark = 'enable' : car.clientUserCarActiveMark = 'disable';
                        }
                        var arr = {clientUserCarNo: car.clientUserCarNo, minutes: '0'};
                        if (car.clientUserCarActiveMark == 'disable') {
                            data.datas = arr;
                            car.remindTime = '';
                        }

                        if (params.isIOS == "true") {
                            PublicService.sendCommand("changeState", PublicService.json2str(data));
                        } else {
                            client.changeState(PublicService.json2str(data));
                        }
                    })
                    .error(function () {
                        if (params.isIOS == "true") {
                            PublicService.sendCommand("changeState", 'timeOut');
                        } else {
                            client.changeState('timeOut');
                        }
                    })


            }

            //设置停车时长
            $scope.carInModel = {
                remindTime: ''
            };

            //添加车辆
            $scope.addCar = function () {
                if (params.isIOS == "true") {
                    PublicService.sendCommand("addCar", "addCar");
                } else {
                    client.addCar();
                }
            }

            //删除
            $scope.del = function (car) {
                var url =
                    "/OnlineParking/rest/deleteUserCarByCarManageId?" +
                    "carManageId=" + car.carManageId +
                    "&clientUserId=" + params.clientUserId +
                    "&clientUserSecurity=" + params.clientUserSecurity;

                PublicService.getListByURL(url)
                    .success(function (data) {
                        // console.log(data)
                        //var index = _this.findIndex($scope.cars.datas, 'clientUserCarNo', car.clientUserCarNo);
                        //$scope.cars.datas.splice(index, 1);
                        if (params.isIOS == "true") {
                            PublicService.sendCommand("delCarNoData", PublicService.json2str(data));
                        } else {
                            client.delCarNo(PublicService.json2str(data));
                        }
                    })
                    .error(function () {
                        if (params.isIOS == "true") {
                            PublicService.sendCommand("delCarNo", "timeOut");
                        } else {
                            client.delCarNo("timeOut");
                        }
                    })
            }


            //清空全部提醒时间
            $scope.removeAllRmindTime = function () {
                angular.forEach($scope.cars.datas, function (item, key) {
                    item.remindTime = '';
                })
            }


            _this.findIndex = function (arry, field, fieldVal) {
                var index = -1;
                angular.forEach(arry, function (item, key) {
                    if (item[field] === fieldVal) {
                        index = key;
                        return;
                    }
                })
                return index;
            }


            $scope.getParame = function (timearr, clientUserCarNo) {
                var minutes = parseInt(timearr[0]) * 60 + parseInt(timearr[1]);
                var str = "clientUserCarNo:" + clientUserCarNo + "&minutes:" + minutes;
                return str;
            }


        }])


        .directive('iscroll', function (PublicService) {
            return {
                restrict: 'A',
                controller: 'carListCtrl',
                scope: {
                    car: '=',
                },
                link: function (scope, ele, attr) {
                    ele.scroller({
                        buttons: [
                            'set', {
                                text: '开始',
                                handler: function (e, inst, that) {
                                    scope.$parent.removeAllRmindTime();
                                    if (!(inst.values[0] == '0' && inst.values[1] == '0')) {
                                        scope.$apply(scope.car.remindTime = inst.values);
                                        var minutes = parseInt(scope.car.remindTime[0]) * 60 + parseInt(scope.car.remindTime[1]);
                                        var parame = "clientUserCarNo:" + scope.car.clientUserCarNo + "&minutes:" + minutes;
                                        if (scope.car.isIOS == "true") {
                                            PublicService.sendCommand("setAlarmTime", parame);
                                        } else {
                                            client.setAlarmTime(parame);
                                        }
                                        inst.cancel();
                                    }
                                }
                            },
                            'cancel', {
                                text: '停止',
                                handler: function (e, inst, that) {
                                    scope.$apply(scope.car.remindTime = '');
                                    var parame = "clientUserCarNo:" + scope.car.clientUserCarNo + "&minutes:" + 0;
                                    if (scope.car.isIOS == "true") {
                                        PublicService.sendCommand("setAlarmTime", parame);
                                    } else {
                                        client.setAlarmTime(parame);
                                    }
                                    inst.cancel();
                                }
                            },
                        ],
                        setText: null,
                        cancelText: null,
                        preset: 'time',
                        theme: 'Default',
                        mode: 'Scroller',
                        display: 'modal',
                        animate: 'fade',
                        headerText: '设置提醒时长',
                        onBeforeShow: function (inst) {
                            inst.temp = scope.car.remindTime;
                        }
                    })

                }
            }
        })

    ;
})()


