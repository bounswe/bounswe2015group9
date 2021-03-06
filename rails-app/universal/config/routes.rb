Rails.application.routes.draw do
  devise_for :admin_users, ActiveAdmin::Devise.config
  ActiveAdmin.routes(self)
  use_doorkeeper
  devise_for :users, :controllers => { registrations: 'registrations' }

  root 'home#index'
  resources :users, only: :show
  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products
  resources :violations do
    collection do
      post 'districts'
      post 'neighborhoods'
      post 'type'
      post 'image_upload'
    end
    member do
      post 'comment'
      post 'rating'
    end
  end

  resources :uploads




  # Api v1
  namespace :api do
    namespace :v1 do
      resources :violations do
        member do
          post 'comment'
          post 'rating'
        end
      end
      resources :registrations, only: :create
      resources :types, only: :index
      resources :cities, only: :index
      resources :districts, only: :index
      resources :neighborhoods, only: :index
      resources :uploads, only: :create
      resources :tags, only: :index
      resources :users, only: :edit do
        collection do
          post 'me'
          post 'edit'
        end
      end
    end
  end

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end

  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end
end
