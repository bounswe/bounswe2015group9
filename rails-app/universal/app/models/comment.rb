class Comment < ActiveRecord::Base
  belongs_to :user
  belongs_to :violation

  validates :description, presences: true
end
