require 'test_helper'

class ViolationsControllerTest < ActionController::TestCase
  setup do
    @violation = violations(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:violations)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create violation" do
    assert_difference('Violation.count') do
      post :create, violation: {  }
    end

    assert_redirected_to violation_path(assigns(:violation))
  end

  test "should show violation" do
    get :show, id: @violation
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @violation
    assert_response :success
  end

  test "should update violation" do
    patch :update, id: @violation, violation: {  }
    assert_redirected_to violation_path(assigns(:violation))
  end

  test "should destroy violation" do
    assert_difference('Violation.count', -1) do
      delete :destroy, id: @violation
    end

    assert_redirected_to violations_path
  end
end
