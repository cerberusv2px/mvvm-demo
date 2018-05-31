package com.example.sujinv2px.evolvemvvm.utils

data class Response(
        var status: Status,
        var data: String? = null,
        var error: Throwable? = null
) {

    companion object {
        fun loading(): Response {
            return Response(Status.LOADING)
        }

        fun complete(data: String?): Response {
            return Response(Status.COMPLETE, data, null)
        }

        fun error(e: Throwable?): Response {
            return Response(Status.ERROR, null, e)
        }
    }
}