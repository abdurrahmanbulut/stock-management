package com.abdurrahmanbulut.justlearn.di

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import java.nio.charset.StandardCharsets
import kotlin.math.log


class CustomHttpLoggingInterceptor : Interceptor {

    private val logger = HttpLoggingInterceptor.Logger.DEFAULT

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logRequest(request)
        val response = chain.proceed(request)
        return logAndCloneResponse(response)
    }

    private fun logRequest(request: Request) {
        logger.log("LOGGER GOLLUM")
        val separator = "\n-----------------------\n"

        logger.log("REQUEST:")

        logger.log("METHOD: ${request.method}")
        logger.log("URL: ${request.url}")

        logger.log("HEADER ->")
        request.headers.forEach { header ->
            logger.log("    * ${header.first}: ${header.second}")
        }
        logger.log("\n")
        request.body?.let { body ->
            logger.log("BODY: ${bodyToString(body)}")
        }

        logger.log("END REQUEST$separator")
    }


    private fun logAndCloneResponse(response: Response): Response {
        val separator = "\n-----------------------\n"

        val responseBody = response.body
        val responseBodyString = responseBody?.string()

        logger.log("RESPONSE:")

        logger.log("STATUS: ${response.code}")
        logger.log("MESSAGE: ${response.message}")
        logger.log("REQUEST URL: ${response.request.url}")

        logger.log("HEADER")
        response.headers.forEach { header ->
            logger.log("    * ${header.first}: ${header.second}")
        }

        logger.log("\n")
        logger.log("BODY ->")
        responseBodyString?.let {
            logger.log(it)
        }

        logger.log("END RESPONSE$separator")

        return response.newBuilder()
            .body(ResponseBody.create(responseBody?.contentType(), responseBodyString ?: ""))
            .build()
    }

    private fun bodyToString(requestBody: RequestBody): String {
        return try {
            val buffer = okio.Buffer()
            requestBody.writeTo(buffer)
            buffer.readString(StandardCharsets.UTF_8)
        } catch (e: Exception) {
            "Couldn't parse request body"
        }
    }
}