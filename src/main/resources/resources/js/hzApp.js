var hzApp = angular.module('hzApp', []), contextGares = '/bfbdemo/gare';

hzApp.controller('hzCtrl', function ($scope, $http) {
    $http.get('/demobfb/hazelcast/cluster').success(function (data) {
        $scope.hzNodes = data;
    });
});

hzApp.controller('garesCtrl', function ($scope, $http) {

    var getData = function () {
        $http.get(contextGares).success(function (gares) {
            $scope.gares = gares;
        });
    };


    $scope.garesClean = function () {
        $http.delete(contextGares).success(function (gares) {
            $scope.gares = gares;
        });
    };

    $scope.garesRefresh = function () {
        getData();
    };

    $scope.garesLoad = function () {
        $http.post(contextGares, {}).success(function (gares) {
            $scope.gares = gares;
        });
    };

    getData();
});
