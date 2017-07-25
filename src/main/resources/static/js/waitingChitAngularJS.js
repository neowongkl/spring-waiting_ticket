var app = angular.module('waitingchitApp', []);

app.controller('waitingchitCtrl', function($scope, $http) {

	$scope.waitList;
	$scope.inputEmail = "";
	$scope.isInProgress = false;

	$scope.addQueueA = function(){
		console.log("addqueueA");
		$scope.isInProgress = true;
		if($scope.inputEmail){
			$http({
				  method: 'POST',
				  url: '/addQueueA',
				  data: $scope.inputEmail
				})
				.then(function successCallback() {
				    // this callback will be called asynchronously
				    // when the response is available
					console.log("Add queue A success");
					$scope.inputEmail= "";
					$scope.getWaitList();
					$scope.isInProgress = false;

				  }, function errorCallback() {
				    // called asynchronously if an error occurs
				    // or server returns response with an error status.
					  console.log("Add queue A fail");
						$scope.isInProgress = false;
				  });
		}else{
			console.log("no email input");
			$scope.isInProgress = false;
			window.alert("Please enter email");
		}

	};


	$scope.getWaitList = function(){
		console.log("get wait list");
		$http({
			  method: 'GET',
			  url: '/getWaitList'
			})
			.then(function successCallback(response) {
			    // this callback will be called asynchronously
			    // when the response is available
				console.log("get wait list success");
				$scope.waitList = response.data;
			  }, function errorCallback(response) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
				  console.log("get wait list fail");
				  console.log(response);
			  });

	}

	$scope.dequeue = function(){
		console.log("dequeue wait list");
		$scope.isInProgress = true;
		$http({
			  method: 'GET',
			  url: '/dequeueWaitList'
			})
			.then(function successCallback() {
			    // this callback will be called asynchronously
			    // when the response is available
				console.log("dequeue wait list ok");
				$scope.getWaitList();
				$scope.isInProgress = false;
			  }, function errorCallback() {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
				  console.log("dequeue wait list fail");
					$scope.isInProgress = false;
			  });

	}


	$scope.getWaitList();


});
