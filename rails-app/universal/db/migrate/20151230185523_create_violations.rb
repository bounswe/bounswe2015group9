class CreateViolations < ActiveRecord::Migration
  def change
    create_table :violations do |t|
      t.references :user, index: true, foreign_key: true
      t.references :city, index: true, foreign_key: true
      t.references :district, index: true, foreign_key: true
      t.references :neighborhood, index: true, foreign_key: true

      t.string :title
      t.text :description
      t.boolean :closed, default: false
      t.text :address

      t.timestamps null: false
    end
  end
end
