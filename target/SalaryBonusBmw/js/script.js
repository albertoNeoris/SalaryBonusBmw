var app = angular.module('app', []);

app.controller("login", function($scope, $http, $window, $location) {

	$scope.login = function() {
		$http.get('./webresources/users/').then(
						function(response) {
							var length = 0;

									console.log("Bienvenido");
									$window.location= "users.html";


						}, function errorCallback(response) {
							console.log('error');
						});
		
}});

app.controller("myangularController", function($scope, $http, $window, $location) {

	$http.get('./webresources/users/status').then(function(response) {
		


		$scope.datos = response.data;
		
		console.log($scope.datos);
	}, function(error){
		console.log('Error'+ error);
	});
	
	$scope.desactivaUser = function(user) {
		user.active="0";
		$http.put('./webresources/users/'+ user.userid, user).then(function() {
			$window.alert("Usuario Desactivado");
			$window.location("users.html");
			console.log(id);
			
			
		})
		
	}
	

	$http.get('./webresources/roles/').then(function(response){
		$scope.roles = response.data;
		console.log($scope.roles);
	}, function(error){
		console.log('Error'+ error);
	});

	$http.get('./webresources/groups/').then(function(response){
		$scope.groups = response.data;
		console.log($scope.groups);
	}, function(error){
		console.log('Error'+ error);
	});
	
	$http.get('./webresources/employees/').then(function(response){
		$scope.employees = response.data;
		console.log($scope.employees);
	}, function(error){
		console.log('Error'+ error);
	});

	
	$scope.findUser = function(id){
		$http.get('./webresources/users/'+ id).then(function(response){
			$scope.user = response.data;
			console.log($scope.user);
		}, function(error){
			console.log('Error' + error);
		});
	}


	$scope.agregaUser = function(){
		$http.post('./webresources/users/', $scope.formData).then(function(response){
			console.log($scope.formData);
			alert("Usuario Agregado");
			$window.location = "users.html";
		}, function(error){
			alert($scope.formData);
			alert($scope.formData.employee+" and " + $scope.formData.role.idrol);
			console.log('Error'+$scope.formData);
		});
	}	


	$scope.modificaUser = function(id){
		$http.put('./webresources/users/' + id, $scope.user).then(function(response){
			$scope.user = {};
			$scope.user = response.data;
			alert("Usuario modificado");
			$window.location= "users.html";
			console.log(response.data);
		}, function(error){
			console.log('Error'+data);
		});
	}	

		
	$scope.borraUser = function(id) {
		$http.delete('./webresources/users/'+ id).then(function(data){
			$scope.todos = data;
			alert("Usuario Eliminado");
			$window.location= "users.html";
			console.log(id);
		})
	}
	
	$scope.findRol = function(id){
		$http.get('./webresources/roles/'+ id).then(function(response){
			$scope.role = response.data;
			console.log($scope.role);
		}, function(error){
			console.log('Error' + error);
		});
	}


	$scope.agregaRol = function(){
		$http.post('./webresources/roles/', $scope.formData).then(function(response){
			console.log($scope.formData);
			alert("Rol Agregado");
			$window.location = "roles.html";
		}, function(error){
			console.log('Error'+$scope.formData);
		});
	}	


	$scope.modificaRol = function(id){
		$http.put('./webresources/roles/' + id, $scope.role).then(function(response){
			$scope.role = {};
			$scope.role = response.data;
			alert("Rol modificado");
			$window.location= "roles.html";
			console.log(response.data);
		}, function(error){
			console.log('Error'+data);
		});
	}	

	
	$scope.borraRol = function(id) {
		$http.delete('./webresources/roles/'+ id).then(function(data){
			alert("Rol Eliminado");
			$window.location= "roles.html";
			console.log(id);
		})
	}
	
	$scope.findEmp = function(id){
		$http.get('./webresources/employees/'+ id).then(function(response){
			$scope.employee = response.data;
			console.log($scope.employee);
		}, function(error){
			console.log('Error' + error);
		});
	}


	$scope.agregaEmp = function(){
		$http.post('./webresources/employees/', $scope.formDataEmp).then(function(response){
			console.log($scope.formDataEmp);
			alert("Empleado Agregado");
			$window.location = "employees.html";
		}, function(error){
			console.log('Error'+$scope.formData);
		});
	}	


	$scope.modificaEmp = function(id){
		$http.put('./webresources/employees/' + id, $scope.employee).then(function(response){
			alert("Empleado modificado");
			$window.location= "employees.html";
			console.log(response.data);
		}, function(error){
			console.log('Error'+data);
		});
	}	

	
	$scope.borraEmp = function(id) {
		$http.delete('./webresources/employees/'+ id).then(function(data){
			alert("Empleado Eliminado");
			$window.location= "employees.html";
			console.log(id);
		})
	}
	
});