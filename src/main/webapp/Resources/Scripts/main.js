/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $(".dropdown-button").dropdown({
        belowOrigin: true // Displays dropdown below the button
    });

    $('.parallax').parallax();

    $('select').material_select();

    // Initialize Materialize collapse button
    $(".button-collapse").sideNav();

    //Modals
    $('.modal-trigger').leanModal();

    //Slider
    $('.slider').slider({full_width: true});

    $('#selectAll').click(function (event) {  //on click 
        var select_class = $(this).attr('title');
        if (this.checked) { // check select status
            $('.selectable').each(function () { //loop through each checkbox
                this.checked = true; //select all checkboxes with class "checkbox1"               
            });
            $('#' + select_class).removeClass('disabled');
            $('#' + select_class).removeAttr('disabled');
        } else {
            $('.selectable').each(function () { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                       
            });
            //Finally disable the submit button
            $('#' + select_class).attr('disabled', 'disabled');
            $('#' + select_class).addClass('disabled');
        }
    });

    $('.selectable').click(function (event) {  //on click 

        //First thing to do, uncheck the select all checkbox
        $('#selectAll').attr('checked', false);
        var select_class = $(this).attr('title');
        if (this.checked) { // check select status
            $('#' + select_class).removeClass('disabled');
            $('#' + select_class).removeAttr('disabled');
        } else {
            if ($('#' + select_class).attr('disabled') !== 'disabled') {//If the button isn't disabled
                //Immediately disable the submit button
                $('#' + select_class).attr('disabled', 'disabled');
                $('#' + select_class).addClass('disabled');
                //Then...
                $('.selectable').each(function (index, element) { //loop through each checkbox
                    if (this.checked) { //If any are checked re-enable the button
                        $('#' + select_class).removeClass('disabled');
                        $('#' + select_class).removeAttr('disabled');
                        return;
                    }
                });
            }
        }

    });

    $('.required').each(function (index, element) {
        element.attr('required');
    });


    if ($('ul.section').length !== 0) {
        $('ul.section').pushpin({top: $('ul.section').offset().top, offset: 50, bottom: $('body').height() - ($('footer').height() + $('.music-header').height())});
        $('.scrollspy').scrollSpy();
    }

    $("#more_services").click(function (e) {
        e.preventDefault();
        $(".additional_services").slideToggle('slow', 'swing');
        $("i", this).toggleClass("fa-plus fa-minus");
    });

    $(".collapsible-header").click(function (e) {
        e.preventDefault();
        $("i", this).toggleClass("fa-chevron-right fa-chevron-down");
    });

    $(".hidden_rows").hide();


    $('.phone_us').mask('(000) 000-0000');
});

