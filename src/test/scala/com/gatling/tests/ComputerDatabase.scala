package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ComputerDatabase extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("application/json, text/plain, */*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9,ta;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36 Edg/130.0.0.0")

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
		"priority" -> "u=0, i",
		"sec-ch-ua" -> """Chromium";v="130", "Microsoft Edge";v="130", "Not?A_Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_1 = Map(
		"If-None-Match" -> """W/"2b77c138b350efb10aa0396ef3500e45"""",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"sec-ch-ua" -> """Chromium";v="130", "Microsoft Edge";v="130", "Not?A_Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_2 = Map(
		"If-None-Match" -> """W/"725f5c83598c8db2a1ab36b57686f3a9"""",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "cross-site",
		"sec-ch-ua" -> """Chromium";v="130", "Microsoft Edge";v="130", "Not?A_Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_3 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
		"priority" -> "u=0, i",
		"sec-ch-ua" -> """Chromium";v="130", "Microsoft Edge";v="130", "Not?A_Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_6 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
		"origin" -> "https://computer-database.gatling.io",
		"priority" -> "u=0, i",
		"sec-ch-ua" -> """Chromium";v="130", "Microsoft Edge";v="130", "Not?A_Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val uri1 = "https://highvocab.com/api/v1"

	val scn = scenario("ComputerDatabase")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/users/profile")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_2")
			.get(uri1 + "/vocabularies/all")
			.headers(headers_2)
			.resources(http("request_3")
			.get("/computers/new")
			.headers(headers_3), http("request_4")
			.get(uri1 + "/users/profile")
			.headers(headers_1), http("request_5")
			.get(uri1 + "/vocabularies/all")
			.headers(headers_2)))
		.pause(15)
		.exec(http("request_6")
			.post("/computers")
			.headers(headers_6)
			.formParam("name", "nandha")
			.formParam("introduced", "")
			.formParam("discontinued", "")
			.formParam("company", "4")
			.resources(http("request_7")
			.get(uri1 + "/users/profile")
			.headers(headers_1), http("request_8")
			.get(uri1 + "/vocabularies/all")
			.headers(headers_2)))
		.pause(47)
		.exec(http("request_9")
			.get("/computers?f=mycoputer")
			.headers(headers_3)
			.resources(http("request_10")
			.get(uri1 + "/users/profile")
			.headers(headers_1), http("request_11")
			.get(uri1 + "/vocabularies/all")
			.headers(headers_2)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}