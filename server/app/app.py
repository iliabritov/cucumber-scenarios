from pathlib import Path
from flask import Flask, request, render_template


app = Flask(__name__)


def get_user_info(company_id, user_name):
	# reading user's info from file in company folder
    user_data_file = Path(f"company/{company_id}/{user_name}")
    with user_data_file.open() as data_file:
        return data_file.read()


def check_user(token, req_company):
	# compare user's company with request company.
	# token form - <user_company>_<user_name>
	if token:
		user_company, _ = token.split("_")
		if user_company == req_company:
			return True


@app.route("/company/<company_id>/users", methods=["GET"])
def get_data(company_id):
	token = request.cookies["whoami_token"]
	req_user = request.args.get("name")

	if check_user(token, company_id):
		data = get_user_info(company_id, request.args.get("name"))
		return f"Company: {company_id}, User data: {data}!!!"
	else:
		return "Permission denied", 403

