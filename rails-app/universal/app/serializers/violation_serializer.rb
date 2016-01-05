class ViolationSerializer < ActiveModel::Serializer
  attributes :id, :title, :description, :closed, :created_at, :tag_list

  has_one :user
  has_one :type
  has_one :city
  has_one :district
  has_one :neighborhood
end