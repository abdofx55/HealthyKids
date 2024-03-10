package com.healthykids.utils

class Constants {

    object Network {
        const val BASE_URL_KEY = "BASE_URL"
        const val URL_USER_MANAGEMENT = "user-management/api"
        const val CONNECT_TIMEOUT = 20L
        const val READ_TIMEOUT = 20L
        const val WRITE_TIMEOUT = 20L
        const val HEADER_CONTENT_TYPE = "Content-Type"
        const val HEADER_CONTENT_TYPE_VALUE = "application/json"
        const val ENCYPT = "multipart/form-data"
        const val HEADER_AUTHORIZATION = "Authorization"
        const val REMOVE_AUTHORIZATION = "remove-authorization"
        const val REFRESH_TOKEN_EXCEPTION = "Refresh Token Exception"
        const val EAHS_WEBSITE = "https://www.eahs.online/"
    }

    object Configuration {
        const val FLOW_REPLAY_CACHE = 999
        const val FLOW_BUFFER_CAPACITY = 99
        const val OTP_TIMER_MAX = 60
        const val DELAY_AFTER_LOGIN = 250L
    }

    object Intent {
        const val SESSION_EXPIRED = "session-expired"
        const val USER = "user"
        const val LOGIN_SUCCEED = "login-succeed"
        const val ENROLLMENT_SUCCEED = "enrollment-succeed"
        const val BID_SUCCEED = "bid-succeed"
        const val EMAIL = "email"
        const val SECTION = "section"
        const val PAGE_TYPE = "pageType"
        const val AUCTION_ID = "auctionId"
        const val AUCTION_NAME = "auctionName"
        const val AUCTION_TYPE = "auctionType"
        const val AUCTION_FEES = "auctionFees"
        const val AUCTION_FEES_ = "auction_fees"
        const val USER_ID = "userId"
        const val BANK_TRANSFER_USER_ID = "userID"
        const val BANK_TRANSFER_Auction_ID = "AuctionID"
        const val AUCTION_ID_ = "auction_id"
        const val AUCTION_DETAILS = "auctionDetails"
        const val AUCTION_FILTER = "auctionFilter"
        const val HORSE_ID = "horseId"
        const val HORSE_NAME = "horseName"
        const val HORSE_FILTER = "horseFilter"
        const val BID_REQUEST = "bidRequest"
        const val INCREMENTAL_INCREASE = "incrementalIncrease"
        const val MEDIA = "media"
        const val LATEST_BID = "latestBid"
        const val NOTIFICATION_TYPE = "notificationType"
        const val OPERATION_TYPE = "operationType"


    }

    object Format {
        const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val AUCTION_FORMAT_ENGLISH = "dd/MM/yyyy"
        const val AUCTION_FORMAT_ARABIC = "yyyy/MM/dd"
        const val AUCTION_FILTER_FORMAT = "dd/MM/yyyy"
        const val AUCTION_TIMER_FORMAT = "d 'd' : H 'h' : m 'm' : s 's'"
        const val HORSE_TIMER_FORMAT_ENGLISH = "d 'd' : H 'h' : m 'm' : s 's'"
        const val HORSE_TIMER_FORMAT_ARABIC = "d 'ي' : H 'س' : m 'د' : s 'ث'"

    }

    object Regex {
        const val PHONE_REGEX = "^(?:\\+\\d{1,3}[-.●]?)?\\d{6,14}\\d\$"
        const val PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"

        /*  ^                 # start-of-string
            (?=.*[0-9])       # at least 1 digit
            (?=.*[a-z])       # at least 1 lower case letter
            (?=.*[A-Z])       # at least 1 upper case letter
            (?=.*[a-zA-Z])"   # any letter
            (?=.*[@#$%^&+=])  # at least 1 special character
            (?=\S+$)          # no white spaces
            .{8,}             # anything, at least four places though
            $                 # end-of-string  */
        const val YOUTUBE_LINK_REGEX =
            "http(?:s)?://(?:www\\.)?youtu(?:\\.be/|be\\.com/(?:watch\\?v=|v/|embed/|user/(?:[\\w#]+/)+))([^&#?\\n]+)"

    }


}