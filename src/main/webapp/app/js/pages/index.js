/**
 * Created by RuiXue on 2015/12/3.
 */

$(function () {

        // 百度地图API功能
        var map = new BMap.Map("maps"),
            markers = [],
            preCurrMarker=null,
            gpsImgSrc = "css/images/icon-gps-blue.png",//停车场默认图标地址
            gpsImgSrcCurr = "css/images/icon-gps-curr.png",//停车场默认图标地址
            userLng = 116.466136,//当前手机用户的经纬度
            userLat = 39.961887,
        //获取后台返回数据
            data = {
                "result": "1", "info": "查询成功", "datas": [{
                    "parkingInfoId": "2300cda8a92f4b869dc025a6fba7121c",
                    "parkingInfoName": "天元港中心停车场",
                    "parkingInfoAddress": "三元桥桥下",
                    "parkingInfoLongitude": "116.466136",
                    "parkingInfoLatitude": "39.961887",
                    "parkingInfoParkingSpaces": "200",
                    "parkingInfoRestParkingSpaces": "197",
                    "parkingInfoState": null
                    ,
                    "parkingInfoCreateTime": null,
                    "parkingInfoCreateManagerType": null,
                    "parkingInfoCreateManagerId": null
                }
                    , {
                        "parkingInfoId": "5fae080c1b1c408b95b7dadb74d4e866",
                        "parkingInfoName": "cccccc",
                        "parkingInfoAddress": "dvgbgnm",
                        "parkingInfoLongitude": "116.46434",
                        "parkingInfoLatitude": "39.960023",
                        "parkingInfoParkingSpaces": "100",
                        "parkingInfoRestParkingSpaces": "100",
                        "parkingInfoState": null,
                        "parkingInfoCreateTime": null,
                        "parkingInfoCreateManagerType": null,
                        "parkingInfoCreateManagerId": null
                    }, {
                        "parkingInfoId": "6d7e15c8a4634aa0807839452f1d1e24",
                        "parkingInfoName": "凤凰城停车场",
                        "parkingInfoAddress": "三元桥附近",
                        "parkingInfoLongitude": "116.458842",
                        "parkingInfoLatitude": "39.968115",
                        "parkingInfoParkingSpaces": "5055",
                        "parkingInfoRestParkingSpaces": "30",
                        "parkingInfoState": null
                        ,
                        "parkingInfoCreateTime": null,
                        "parkingInfoCreateManagerType": null,
                        "parkingInfoCreateManagerId": null
                    }
                    , {
                        "parkingInfoId": "adda3a17866041f78840b6e59aaabab6",
                        "parkingInfoName": "xxxxx",
                        "parkingInfoAddress": "dsdsd"
                        ,
                        "parkingInfoLongitude": "116.46923",
                        "parkingInfoLatitude": "39.961848",
                        "parkingInfoParkingSpaces": "11"
                        ,
                        "parkingInfoRestParkingSpaces": "1",
                        "parkingInfoState": null,
                        "parkingInfoCreateTime": null,
                        "parkingInfoCreateManagerType": null,
                        "parkingInfoCreateManagerId": null
                    }]
            };

        /**
         * 加载地图
         */
        function loadMap() {
            map.centerAndZoom(new BMap.Point(userLng, userLat), 15);//设置地图视觉中心点
        }

        /**
         * 地图主入口，生成附近停车场的点图标
         */
        function init(data) {
            $("#maps").height($(window).height());
            loadMap();
            if (data.datas.length) {
                for (var i = 0; i < data.datas.length; i++) {
                    var lng = data.datas[i].parkingInfoLongitude,
                        lat = data.datas[i].parkingInfoLatitude;

                    var myIcon = new BMap.Icon(gpsImgSrc, new BMap.Size(22, 35));
                    var marker = new BMap.Marker(new BMap.Point(lng, lat), {icon: myIcon});  // 创建标注

                    //添加车位数字
                    var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(lng, lat), data.datas[i].parkingInfoRestParkingSpaces);
                    map.addOverlay(myCompOverlay);

                    marker.index = i;
                    markers.push(marker);

                    map.addOverlay(marker);

                    marker.addEventListener("click", setParkingInfoByIndex);
                    marker.addEventListener("click", parkindInfoBoxShow);

                    //将默认最近（第0个）的停车信息写在页面下方
                    if (i == 0) {
                        //停车场名称
                        $("#parkingInfoBox h3").text(data.datas[i].parkingInfoName);
                        //总车位
                        $("#parkingInfoParkingSpaces").text(data.datas[i].parkingInfoParkingSpaces);
                        //剩余车位
                        $("#parkingInfoRestParkingSpaces").text(data.datas[i].parkingInfoRestParkingSpaces);
                        //停车场地址
                        $("#parkingInfoAddress").text(data.datas[i].parkingInfoAddress);

                        //移动视觉中心
                        resetCenterAndZoom(lng, lat);

                        //设置激活状态
                        preCurrMarker= addMarker(lng,lat,gpsImgSrcCurr,23,35);

                    }
                }
            }
            else{
                alert("未找到您附近的停车场");
            }
        }


        /**
         * 根据用户点击停车场坐标点设置对应停车场信息
         * @param    {event}
         */
        function setParkingInfoByIndex(e) {

            var p = getPosition(e);
            if (p) {
                parkindInfoBoxHidden();
                //alert("该覆盖物是点，点的坐标是：" + p.getPosition().lng + "," + p.getPosition().lat+",index:"+p.index);
                var lng = p.lng,
                    lat = p.lat;
                //停车场名称
                $("#parkingInfoBox h3").text(data.datas[p.p.index].parkingInfoName);
                //总车位
                $("#parkingInfoParkingSpaces").text(data.datas[p.p.index].parkingInfoParkingSpaces);
                //剩余车位
                $("#parkingInfoRestParkingSpaces").text(data.datas[p.p.index].parkingInfoRestParkingSpaces);
                //停车场地址
                $("#parkingInfoAddress").text(data.datas[p.p.index].parkingInfoAddress);

                //移动视觉中心
                resetCenterAndZoom(lng, lat);
                //动画
                /*for(var i=0;i<markers.length;i++){
                 markers[i].setAnimation(null);
                 }
                 p.setAnimation(BMAP_ANIMATION_BOUNCE);*/


                /*var myIcon = new BMap.Icon("css/images/icon-gps-blue.png", new BMap.Size(22,35));
                 var marker = new BMap.Marker(new BMap.Point(p.getPosition().lng, p.getPosition().lat),{icon:myIcon});
                 map.addOverlay(marker);
                 var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(p.getPosition().lng ,p.getPosition().lat),parkingData.datas[p.index].parkingInfoRestParkingSpaces,"#FF9D00");
                 map.addOverlay(myCompOverlay);
                 */

                //激动状态
                map.removeOverlay(preCurrMarker);
                preCurrMarker = addMarker(lng,lat,gpsImgSrcCurr,23,35);

                parkindInfoBoxShow();

            } else {
                alert("无法获知该覆盖物类型");
                parkindInfoBoxShow();
            }

        }

        /**
         * 新建Marker
         * @param    {string}    lng纬度
         * @param    {string}    lat经度
         * @param    {string}    iconSrc图标地址
         * @param    {num}       iconW图片宽度
         * @param    {num}       iconH图片高度
         * @return   {marker}    Marker
         */
        function addMarker(lng,lat,iconSrc,iconW,iconH){
            var myIcon = new BMap.Icon(iconSrc, new BMap.Size(iconW, iconH));
            var marker = new BMap.Marker(new BMap.Point(lng, lat), {icon: myIcon})
            map.addOverlay(marker);
            return marker;
        }

        /**
         * 设置停车激活状态
         * @param    {string}    lng纬度
         * @param    {string}    lat经度
         */
        function setParkingCurr(lng, lat) {

        }

        /**
         * 获取用户点击位置的坐标
         * @return {Object} p:Marker对象 lng:经度 lat:纬度
         */
        function getPosition(e) {
            var result = {},
                p = e.target;
            if (p instanceof BMap.Marker) {
                result.p = p;
                result.lng = p.getPosition().lng;
                result.lat = p.getPosition().lat;
            }
            return result || null;
        }


        /**
         * 隐藏当前停车场信息栏
         **/
        function parkindInfoBoxHidden() {
            $(".parkingInfoBox").animate({
                bottom: "-9rem"
            }, {
                easing: 'easeInQuart',
                duration: 300
            });
        }

        /**
         * 显示
         **/
        function parkindInfoBoxShow() {
            $(".parkingInfoBox").animate({
                bottom: "0"
            }, {
                easing: 'easeOutQuart',
                duration: 300
            });
        }

        /**
         * 重新设置地图视觉中心
         */
        function resetCenterAndZoom(lng, lat, zoom) {
            zoom = zoom || 15;
            map.panTo(new BMap.Point(lng, lat));
            setTimeout(function () {
                map.centerAndZoom(new BMap.Point(lng, lat), zoom);//设置地图视觉中心点
                map.enableScrollWheelZoom(true);
            }, 700);

        }

        /**
         * 添加车位数
         */
        function ComplexCustomOverlay(point, text, color) {
            this._point = point;
            this._text = text;
            this._color = color || "white";
        }

        ComplexCustomOverlay.prototype = new BMap.Overlay();
        ComplexCustomOverlay.prototype.initialize = function (map) {
            this._map = map;
            var div = this._div = document.createElement("div");
            div.style.position = "absolute";
            div.style.zIndex = BMap.Overlay.getZIndex(this._point.lat);
            div.style.color = this._color;
            div.style.width = "28px";
            div.style.height = "18px";
            div.style.padding = "2px";
            div.style.textAlign = "center";
            div.style.lineHeight = "18px";
            div.style.whiteSpace = "nowrap";
            div.style.MozUserSelect = "none";
            div.style.fontSize = "12px"
            div.style.fontWeight = "700"
            var span = this._span = document.createElement("span");
            div.appendChild(span);
            span.appendChild(document.createTextNode(this._text));
            var that = this;

            map.getPanes().labelPane.appendChild(div);

            return div;
        }
        ComplexCustomOverlay.prototype.draw = function () {
            var map = this._map;
            var pixel = map.pointToOverlayPixel(this._point);
            //this._div.style.left = pixel.x - parseInt(this._arrow.style.left) + "px";
            this._div.style.left = pixel.x - 15 + "px";
            this._div.style.top = pixel.y - 16 + "px";
        }


        /*==========================================================================*/

        /**
         * 启动地图
         */
        init(data);

        /**
         * 定位
         */
        $("#btn-getCurrentPosition").click(function () {
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function (r) {
                if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                    var mk = new BMap.Marker(r.point);
                    map.addOverlay(mk);
                    map.panTo(r.point);
                    //alert('您的位置：'+r.point.lng+','+r.point.lat);
                }
                else {
                    alert('failed' + this.getStatus());
                }
            }, {enableHighAccuracy: true})
        });

        /**
         * 隐藏停车场信息盒子
         */
        $(".icon-parkingInfo-hide").click(function () {
            parkindInfoBoxHidden();
        });

        //测试方法
        $(".text-blue").click(function () {
            client.test("Hello World!");
        });
    }
);

