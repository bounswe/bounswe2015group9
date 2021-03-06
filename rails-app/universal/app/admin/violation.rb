ActiveAdmin.register Violation do

  index do
    selectable_column
    id_column
    column :title
    column :description
    column :closed
    column :address
    column :created_at
    column :image_url
    actions
  end

# See permitted parameters documentation:
# https://github.com/activeadmin/activeadmin/blob/master/docs/2-resource-customization.md#setting-up-strong-parameters
#
permit_params :list, :of, :attributes, :on, :model
#
# or
#
# permit_params do
#   permitted = [:permitted, :attributes]
#   permitted << :other if resource.something?
#   permitted
# end


end
