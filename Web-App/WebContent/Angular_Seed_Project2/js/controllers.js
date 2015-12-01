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
	$http({
	  method: 'POST',
	  url: 'http://ec2-54-69-10-151.us-west-2.compute.amazonaws.com:8080/universal-access/oauth/token?grant_type=password&username='+'dsd@mail.com'+'&password='+'1234',
	  headers: { 'Authorization': 'Basic Y2xpZW50OnNlY3JldA=='}
	}).then(function (response) {
	    $scope.cevap = response;
	  });
	





};


angular
    .module('inspinia')
    .controller('MainCtrl', MainCtrl)