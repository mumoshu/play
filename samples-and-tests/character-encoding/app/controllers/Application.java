package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index(String encoding) {
        if (encoding != null) {
            response.characterEncoding = encoding;
            Logger.debug("Response character encoding is set to:" + encoding);
        }
        render();
    }

}