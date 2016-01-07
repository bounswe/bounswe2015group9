class Api::V1::UploadsController < Api::V1::BaseController
  def create
    params["upload"] = {"upload" => params["upload"]}
    @upload = Upload.new(upload_params)

    if @upload.save
      render json: {files: [@upload.to_jq_upload]}, status: :created, location: @upload
    else
      render json: @upload.errors, status: :unprocessable_entity
    end
  end

  private

    # Never trust parameters from the scary internet, only allow the white list through.
    def upload_params
      params.require(:upload).permit(:upload)
    end
end
