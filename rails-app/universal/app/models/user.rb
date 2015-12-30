class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

  after_create :create_credentials!

  protected
    def create_credentials!
      Doorkeeper::AccessToken.create!(
        resource_owner_id: id,
        scopes: Doorkeeper.configuration.scopes.to_s
      )
    end
end
