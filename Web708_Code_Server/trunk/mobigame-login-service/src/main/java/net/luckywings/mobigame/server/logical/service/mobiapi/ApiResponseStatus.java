/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service.mobiapi;

/**
 * 
 * @ClassName: ApiResponseStatus
 * @author nikm
 * @date 2013-7-22
 *
 */
public enum ApiResponseStatus {
		OK(200, "OK"),
        CREATED(201, "Created"),
        ACCEPTED(202, "Accepted"),
        NO_CONTENT(204, "No Content"),
        MOVED_PERMANENTLY(301, "Moved Permanently"),
        SEE_OTHER(303, "See Other"),
        NOT_MODIFIED(304, "Not Modified"),
        TEMPORARY_REDIRECT(307, "Temporary Redirect"),
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not Found"),
        NOT_ACCEPTABLE(406, "Not Acceptable"),
        CONFLICT(409, "Conflict"),
        GONE(410, "Gone"),
        PRECONDITION_FAILED(412, "Precondition Failed"),
        UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
        INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
        SERVICE_UNAVAILABLE(503, "Service Unavailable"),
        
        UNKNOWN(0, "Unknown error"),
        NO_ACTION(1, "Action does not exists"),
        NOT_MATCH(2, "Version not match"),
		USER_EXISTS(3, "User exists"),
		USER_NOT_EXISTS(4, "User not exists"),
		FAILED(5, "Do action failed"),
		A_NOT_FINISH(6, "Achievement not finish"),
		A_ALREADY_ACCEPT(7, "Achievement already accept"),
		ALREADY_EXISTS(8, "Already exists"),
		NOT_EXISTS(9, "Item not exists"),
		NO_RESULT(10, "No result found"),
		NAME_EXISTS(11, "Name exists"),
		NOT_ENOUGH(12, "Account amount not enough"),
		MATERIAL_ERROR(13, "Material card error"),
		CG_ENOUGH(14, "Card group enough"),
		CG_REQUIRE_LACK(15, "Leader require not enough"),
		CANT_EVOLVE(16, "Can not evolve"),
		CARD_TOO_MATCH(17, "Card too match"),
		
		HAVE_BEEN_APPLIED(18, "Have been applied"),
		HAVE_BEEN_FRIEND(19, "Have been friend"),
		
		SEND_EMAIL_FAILD(20, "Send email faild"),
		
		USER_PWD_ERROR(21, "Password error"),
		
		
		LOGIN_ERROR(100, "Login error");
		
        
        private final int code;
        private final String reason;
        private Family family;
        
        /**
         * An enumeration representing the class of status code. Family is used
         * here since class is overloaded in Java.
         */
        public enum Family {INFORMATIONAL, SUCCESSFUL, REDIRECTION, CLIENT_ERROR, SERVER_ERROR, OTHER};

        ApiResponseStatus(final int statusCode, final String reasonPhrase) {
            this.code = statusCode;
            this.reason = reasonPhrase;
            switch(code/100) {
                case 1: this.family = Family.INFORMATIONAL; break;
                case 2: this.family = Family.SUCCESSFUL; break;
                case 3: this.family = Family.REDIRECTION; break;
                case 4: this.family = Family.CLIENT_ERROR; break;
                case 5: this.family = Family.SERVER_ERROR; break;
                default: this.family = Family.OTHER; break;
            }
        }
        
        /**
         * Get the class of status code
         * @return the class of status code
         */
        public Family getFamily() {
            return family;
        }
        
        /**
         * Get the associated status code
         * @return the status code
         */
        public int getStatusCode() {
            return code;
        }
        
        /**
         * Get the reason phrase
         * @return the reason phrase
         */
        public String getReasonPhrase() {
            return toString();
        }
        
        /**
         * Get the reason phrase
         * @return the reason phrase
         */
        public String toString() {
            return reason;
        }
        
        /**
         * Convert a numerical status code into the corresponding Status
         * @param statusCode the numerical status code
         * @return the matching Status or null is no matching Status is defined
         */
        public static ApiResponseStatus fromStatusCode(final int statusCode) {
            for (ApiResponseStatus s : ApiResponseStatus.values()) {
                if (s.code == statusCode) {
                    return s;
                }
            }
            return null;
        }
}
