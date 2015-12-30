class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

  has_many :violations
  has_many :ratings

  enum gender: [:male, :female, :other]

  validates :first_name, :last_name, presence: true
  validates :age, numericality: { greater_than_or_equal_to: 0 }


  after_create :create_credentials!

  protected
    def create_credentials!
      Doorkeeper::AccessToken.create!(
        resource_owner_id: id,
        scopes: Doorkeeper.configuration.scopes.to_s
      )
    end
end
