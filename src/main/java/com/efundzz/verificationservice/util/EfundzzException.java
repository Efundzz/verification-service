package com.efundzz.verificationservice.util;

public class EfundzzException extends RuntimeException{

        private String message;

        public EfundzzException(String message) {
            super(message);
            this.message = message;
        }

        public EfundzzException(String message, Throwable cause) {
            super(message, cause);
            this.message = message;
        }

        public EfundzzException(Throwable cause) {
            super(cause);
        }

        public EfundzzException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
            this.message = message;
        }
}
