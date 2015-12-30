class District < ActiveRecord::Base
  belongs_to :city

  validates :name, presence: true
end
