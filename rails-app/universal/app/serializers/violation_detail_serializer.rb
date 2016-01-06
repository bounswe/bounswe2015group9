class ViolationDetailSerializer < ActiveModel::Serializer
  attributes :id, :title, :description, :closed, :created_at, :address, :tag_list

  has_one :user
  has_one :type
  has_one :city
  has_one :district
  has_one :neighborhood
  has_many :comments
end