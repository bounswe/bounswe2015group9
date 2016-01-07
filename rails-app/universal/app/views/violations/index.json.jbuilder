json.array!(@violations) do |violation|
  json.extract! violation, :id
  json.url violation_url(violation, format: :json)
end
