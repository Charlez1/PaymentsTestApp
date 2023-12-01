package com.stu.paymentstestapp

open class AppException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
}

class AuthenticationException(message: String) : AppException(message)
class NetworkException(message: String) : AppException(message)
class InvalidTokenException(message: String) : AppException(message)
