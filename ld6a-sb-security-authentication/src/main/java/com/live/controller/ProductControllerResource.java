package com.live.controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class ProductControllerResource {
@GetMapping("/")
public String index() {
	String html="<html>";
	html += html + "<head><title>Welcome Page</title></head>";
	html += "<body>Welcome!! The Produts Homr Page</body>";
	html += "</html>";
	return html;
}
@GetMapping("/user")
public String userpage() {
	String html="<html>";
	html += html + "<head><title>Welcome Page</title></head>";
	html += "<body>Welcome User!! </body>";
	html += "</html>";
	return html;
}
@GetMapping("/admin")
public String adminpage() {
	String html="<html>";
	html += html + "<head><title>Welcome Page</title></head>";
	html += "<body>Welcome admin!!</body>";
	html += "</html>";
	return html;
}
}