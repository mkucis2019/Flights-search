app.controller('adminController', function($scope, $http, NgTableParams) {
   $scope.status = 0;
   $scope.update = function() {
		$http.get(server + "/data/airport")
		.then(function (response) {
			$scope.airports = response.data;
			 $scope.tableParams = new NgTableParams({page: 1, count: 30 }, { total: $scope.airports.length, counts: [],
			      getData: function (params) {
			           $scope.viewData = $scope.airports.slice((params.page() - 1) * params.count(), params.page() * params.count());
			           return $scope.viewData;
			      } });
		});
	};
	
   $scope.update();
   $scope.logout = function() {
	   window.location = "/logout";
   };
   
   $scope.create = function() {
	   var params = {"name": $scope.airportName, "iataCode": $scope.iataCode.toUpperCase() };
	   $scope.status = 1;
	   $http.post(server + "/data/airport", params)
		.then(function (response) {
		    $scope.status = 0;
		    $scope.update();
		}, function(response) {$scope.status = 2;});
   };
  
   $scope.delete = function(index) {
	   $scope.status = 0;
	   $http.delete(server + "/data/airport/" + $scope.viewData[index].id)
		.then(function (response) {
		    $scope.status = 0;
		    $scope.update();
		}, function(response) {$scope.status = 2;});
   };
});