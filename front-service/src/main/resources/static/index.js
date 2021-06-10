angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8190/products';

    $scope.showProducts = function () {
        $http({
            url: contextPath + '/get_products',
            method: 'GET'
        }).then(function (response) {
            $scope.productDto = response.data;
        });
    };

    $scope.showProducts();
});