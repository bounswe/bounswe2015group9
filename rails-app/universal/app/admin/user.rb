ActiveAdmin.register User do

# See permitted parameters documentation:
# https://github.com/activeadmin/activeadmin/blob/master/docs/2-resource-customization.md#setting-up-strong-parameters
#

index do
  selectable_column
  id_column
  column :email
  column :last_sign_in_at
  column :first_name
  column :last_name
  column :age
  column :gender
  actions
end

permit_params :id, :first_name, :last_name, :email, :password, :age, :gender
#
# or
#
# permit_params do
#   permitted = [:permitted, :attributes]
#   permitted << :other if resource.something?
#   permitted
# end


end
