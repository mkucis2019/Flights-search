app.controller('searchController', function($scope, $http, NgTableParams) {
   $scope.searchStatus = 0;
   $scope.loadAdmin = function() {
	   window.location = "/admin";  
   };
   $scope.search = function(){
	   if(typeof $scope.option1 == 'undefined' || typeof $scope.option2 == 'undefined') return;
	   $scope.searchStatus = 1;
	   $scope.api = { 'apikey' : 'bFzCSuzHGvfggLcJZ7yJfXjghZWFJCqN', 'origin' : $scope.option1.value, 'destination' : $scope.option2.value, 'departure_date' : $scope.date1, 'return_date': $scope.date2, 'adults': $scope.passengers, 'currency' : $scope.selectedCurrency};
	   $http.get("https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search", { params: $scope.api, cache: true })
	   .then(function (response) {
		   $scope.tableData = [];

		   for (var re of response.data.results) {
			   var pObject = [];
			  
			   pObject.price = re.fare.total_price;
			   for (var it of re.itineraries) {
				   pObject.nFlightsFrom = it.outbound.flights.length;
				   pObject.nFlightsTo = it.inbound.flights.length;
				   pObject.nPassengers = 20 - it.outbound.flights[0].booking_info.seats_remaining;
				   pObject.from = it.outbound.flights[0].origin.airport;
				   pObject.datefrom = it.outbound.flights[0].departs_at;
				   pObject.to = it.outbound.flights[it.outbound.flights.length - 1].destination.airport;
				   pObject.dateto = it.inbound.flights[it.inbound.flights.length - 1].arrives_at;
				   pObject.currency = response.data.currency;
			   }
			   $scope.tableData.push(pObject);
		   }
		   
		   $scope.tableParams = new NgTableParams({page: 1, count: 30 }, { total: $scope.tableData.length, counts: [],
               getData: function (params) {
                   $scope.viewData = $scope.tableData.slice((params.page() - 1) * params.count(), params.page() * params.count());
                   return $scope.viewData;
               } });
		   if(typeof response.data.results !== 'undefined') { 
			   $scope.searchStatus = 2;
			   document.querySelector('#results').scrollIntoView({ behavior: 'smooth'});
		   }
		   else $scope.searchStatus = 3;
		   }, function(response){$scope.searchStatus = 3;});
   };
});
