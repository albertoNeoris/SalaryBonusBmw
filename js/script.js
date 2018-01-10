/**
 * 
 */
var app = angular.module('app', []);

app.controller("myangularController", function($scope, $http, $window, $location) {

	$scope.user1;
	$scope.pass1;

	$scope.login = function() {
		$http.get('./webresources/team').then(
						function(response) {
							var length = 0;
							alert(length);
							angular.forEach(response.data, function(user) {
								if ($scope.user1 == user.userName && $scope.pass1 == user.password) {
									console.log("Bienvenido");
									$window.location= "page2.html";
								} else{
									length++;
								}if (length == response.data.length){
									alert("¡Login failed!");
								}
							});

						}, function errorCallback(response) {
							console.log('error');
							// called asynchronously if an error occurs
							// or server returns response with an error
							// status.
						});
	}
	
	$scope.consultar = function() {
		$window.location = 'page3.html';
	}
	
	$http.get("./webresources/team").then(function (response) {
	      $scope.datos = response.data;
	  });
	
	

});