/**
 * INSPINIA - Responsive Admin Theme
 *
 */

/**
 * MainCtrl - controller
 */
function MainCtrl($scope,$http) {

    this.userName = 'Example user';
    this.helloText = 'Welcome in SeedProject';
    this.descriptionText = 'It is an application skeleton for a typical AngularJS web app.';

    $scope.writeMail=function(){
    	return this.usermail;

    };
    $scope.register=function(){
    	$http({
	  method: 'POST',
	  url: 'http://ec2-54-69-10-151.us-west-2.compute.amazonaws.com:8080/universal-access/oauth/token?grant_type=client_credentials' ,
	  headers: { 'Authorization': 'Basic Y2xpZW50OnNlY3JldA=='}
	}).then(function (responseReg1) {
	    $scope.register1accessTok = responseReg1.access_token;
	  });
	$http({
	  method: 'POST',
	  url: 'http://ec2-54-69-10-151.us-west-2.compute.amazonaws.com:8080/universal-access/rest/users' ,
	  headers: { 'Authorization': 'Bearer '+$scope.register1accessTok },
	  data: { 'email': $scope.registerMail , 'password': $scope.registerPassword, 'firstName' : $scope.registerFName , 'lastName' : $scope.registerLName}
	}).then(function (responseReg2) {

	  });


   	};

    $scope.login=function(){
	$http({
	  method: 'POST',
	  url: 'http://ec2-54-69-10-151.us-west-2.compute.amazonaws.com:8080/universal-access/oauth/token?grant_type=password&username='+this.usermail+'&password='+this.password,
	  headers: { 'Authorization': 'Basic Y2xpZW50OnNlY3JldA=='}
	}).then(function (response2) {
	    $scope.login1Resp = response2;
	  });

	}

};
angular
    .module('inspinia')
    .controller('MainCtrl', MainCtrl)