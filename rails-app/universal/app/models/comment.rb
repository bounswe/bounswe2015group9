class Comment < ActiveRecord::Base
  belongs_to :user
  belongs_to :violation

  validate :description, presences: true
end
