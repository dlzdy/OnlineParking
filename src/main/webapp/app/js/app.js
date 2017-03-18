/**
 * Created by RuiXue on 2015/12/25.
 */
var appOnline = angular.module('appOnline', ['ui.router', 'BillsList','UserCenterFeedBack','UserCenterInfo',
    'UserCenterAboutUs','UserCenterAddCar','userCenterSoftwareAgreement',
    'BillsDetail','MessageDetail','pagination','ngTouch']);

appOnline.run(function ($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
});


appOnline.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/error');
    $stateProvider
    //订单
        .state('bills', {
            url: '/bills',
            templateUrl: 'tpls/bills.html'
        })
        //订单详情 by xumingyue
        .state('bills-detail', {
            url: '/bills-detail',
            templateUrl: 'tpls/bills-detail.html'
        })
        //收费明细 by xumingyue
        .state('charge-detail', {
            url: '/charge-detail',
            templateUrl: 'tpls/charge-detail.html'
        })
        //用户意见反馈 by xumingyue
        .state('userCenter-feedBack', {
            url: '/userCenter-feedBack',
            templateUrl: 'tpls/userCenter-feedBack.html'
        })
        //个人中心
        .state('userCenter-userInfo-list', {
            url: '/userCenter-userInfo-list',
            templateUrl: 'tpls/userCenter-userInfo-list.html'
        })
        .state('userCenter-carList',{
            url: '/userCenter-carList',
            templateUrl: 'tpls/userCenter_car_list.html'
        })
        //添加车辆
        .state('userCenter-addCar', {
            url: '/userCenter-addCar',
            templateUrl: 'tpls/userCenter_addCar.html'
        })
        //添加车辆 for IOS
        .state('userCenter-addCarios', {
            url: '/userCenter-addCarios',
            templateUrl: 'tpls/userCenter_addCar_ios.html'
        })
        //个人信息
        .state('userCenter-info', {
            url: '/userCenter-info',
            templateUrl: 'tpls/userCenter-info.html'
        })
        //修改昵称
        .state('userCenter-editNickName', {
            url: '/userCenter-editNickName',
            templateUrl: 'tpls/userCenter-editNickName.html'
        })
        //钱包充值
        .state('userCenter-wallet', {
            url: '/userCenter-wallet',
            templateUrl: 'tpls/userCenter-wallet.html'
        })
        //钱包充值－充值
        .state('userCenter-wallet-prepaid', {
            url: '/userCenter-wallet-prepaid',
            templateUrl: 'tpls/userCenter-wallet-prepaid.html'
        })
        //系统设置
        .state('userCenter-systemSet', {
            url: '/userCenter-systemSet',
            templateUrl: 'tpls/userCenter-systemSet.html'
        })
        //系统设置--自动支付
        .state('userCenter-systemSet-autoPay', {
            url: '/userCenter-systemSet-autoPay',
            templateUrl: 'tpls/userCenter-systemSet-autoPay.html'
        })
        //关于我们
        .state('userCenter-aboutUs', {
            url: '/userCenter-aboutUs',
            templateUrl: 'tpls/userCenter-aboutUs.html',
            controller: 'ctrlUserCenterAboutUs'
        })
        //软件许可服务协议 by xumingyue
        .state('userCenter-softwareAgreement', {
            url: '/userCenter-softwareAgreement',
            templateUrl: 'tpls/userCenter-softwareAgreement.html',
            controller: 'ctrlUserCenterSoftwareAgreement'
        })
        //免责声明
        .state('userCenter-softwareStatement', {
            url: '/userCenter-softwareStatement',
            templateUrl: 'tpls/userCenter-softwareStatement.html'
        })
        //消息列表by xumingyue
        .state('message-list', {
            url: '/message-list',
            templateUrl: 'tpls/message-list.html',
        })
        //消息详情 by xumingyue
        .state('message-detail', {
            url: '/message-detail',
            templateUrl: 'tpls/message-detail.html',
        })
        //错误页面
        .state('error', {
            url: '/error',
            views: {
                '': {
                    templateUrl: 'tpls/error.html'
                }
            }
        })
});

