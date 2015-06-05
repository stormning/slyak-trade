requirejs.config({
    baseUrl: '/static/js/lib',
    paths: {
        "module": "../module",
        "jquery": "jquery-1.11.1"
    }
});

require(['jquery'],function($){
    console.log($("body"));
});
