var app = angular.module('waitingchitApp', []);

app.controller('waitingchitCtrl', function($scope, $http) {
	
	$scope.waitList;
	$scope.inputEmail;
	
	$scope.addonetotwo = function(){
		console.log("addonetotwo");
		$http({
			  method: 'POST',
			  url: '/addonetotwo',
			  data: $scope.inputEmail
			})
			.then(function successCallback() {
			    // this callback will be called asynchronously
			    // when the response is available
				console.log("ok");
				$scope.inputEmail= "";
				$scope.getWaitList();

			  }, function errorCallback() {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
				  console.log("fail");
			  });
	};
//	
//	$scope.addtwotofour = function(){
//		console.log("addtwotoone");
//		$http({
//			  method: 'GET',
//			  url: '/addtwotoone'
//			})
//			.then(function successCallback(response) {
//			    // this callback will be called asynchronously
//			    // when the response is available
//				console.log("ok");
//				console.log(response);
//			  }, function errorCallback(response) {
//			    // called asynchronously if an error occurs
//			    // or server returns response with an error status.
//				  console.log("fail");
//				  console.log(response);
//			  });
//	};
//	
//	$scope.addfourabove = function(){
//		console.log("addfourabove");
//		$http({
//			  method: 'GET',
//			  url: '/addfourabove'
//			})
//			.then(function successCallback(response) {
//			    // this callback will be called asynchronously
//			    // when the response is available
//				console.log("ok");
//				console.log(response);
//			  }, function errorCallback(response) {
//			    // called asynchronously if an error occurs
//			    // or server returns response with an error status.
//				  console.log("fail");
//				  console.log(response);
//			  });
//	}
	
	$scope.getWaitList = function(){
		console.log("get wait list");
		$http({
			  method: 'GET',
			  url: '/getWaitList'
			})
			.then(function successCallback(response) {
			    // this callback will be called asynchronously
			    // when the response is available
				console.log("ok");
				console.log(response);
				$scope.waitList = response.data;
			  }, function errorCallback(response) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
				  console.log("fail");
				  console.log(response);
			  });
		
	}
	
	$scope.dequeue = function(){
		console.log("dequeue wait list");
		$http({
			  method: 'GET',
			  url: '/dequeueWaitList'
			})
			.then(function successCallback() {
			    // this callback will be called asynchronously
			    // when the response is available
				console.log("ok");
				$scope.getWaitList();
				
			  }, function errorCallback() {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
				  console.log("fail");
			  });
		
	}
	
	
	
	
	$scope.getWaitList();
	
	
});