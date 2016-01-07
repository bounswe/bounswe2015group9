class Type < ActiveRecord::Base
  has_many :violations

  validates :name, :description, presence: true
end
