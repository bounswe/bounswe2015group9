class ViolationSerializer < ActiveModel::Serializer
  attributes :id, :title, :description, :closed, :created_at, :address

  has_one :type
  has_one :city
  has_one :district
  has_one :neighborhood
end