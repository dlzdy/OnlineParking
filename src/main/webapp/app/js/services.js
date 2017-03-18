appOnline.factory('PublicService', ['$http','$window',
    function ($http,$window) {

        var doRequest = function (url,params) {
            return $http({
                method: 'GET',
                url: url,
                params:params
            });
            /*return $http.jsonp(url);*/
            console.log('*************getUrl:'+url);
        }

        return {
            getListByURL: function (url,params) {
                return doRequest(url,params, 'getListByURL');
            },
            //克隆对象
            cloneObj:function(obj){
                function Fn(){}
                Fn.prototype = obj;
                var o = new Fn();
                for(var a in o){
                    if(typeof o[a] == "object") {
                        o[a] = clone(o[a]);
                    }
                }
                return o;
            },
            //json2String
            json2str:function(o){
                return o ? JSON.stringify(o) : "{}";
            },
            sendCommand : function(cmd,data){
            	$window.location = cmd + "==info" + "==" + data ;
            }
        };




        //数据分页
        /*$scope.setPagingData = function (data, page, pageSize) {
         var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
         $scope.orders = pagedData;
         $scope.totalServerItems = data.length;
         if (!$scope.$$phase) {
         $scope.$apply();
         }
         };

         $scope.getPagedDataAsync = function (pageSize, page, searchText) {

         setTimeout(function () {
         var data;
         if (searchText) {
         var ft = searchText.toLowerCase();
         $http.get(urlBills)
         .success(function (largeLoad) {
         data = largeLoad.datas.filter(function (item) {
         return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
         });
         $scope.setPagingData(data, page, pageSize);
         });
         $scope.loadingPage = false;
         } else {
         $http.get(urlBills)
         .success(function (largeLoad) {
         $scope.setPagingData(largeLoad.datas, page, pageSize);
         });
         $scope.loadingPage = false;
         }
         }, 1000);
         };

         $scope.getPagedDataAsync(10, 1);*/

    }
]);