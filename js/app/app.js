
  var app = angular.module('sdppb', []);

  app.controller('TeamController', ['$http', function($http){
    var team = this;
    team.members = [];
    
    $http.get('./webresources/team').success(function(data){
        team.members = data;
    });
    
    team.changeQuarter = function(){
        console.log('asdasd');
      team.members[0].name = 'Q1';  
    };
    
    
  }]);
  
