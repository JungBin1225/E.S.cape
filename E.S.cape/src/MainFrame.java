import java.applet.Applet;
import java.applet.AudioClip;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class MainFrame 
{
	JFrame frame = new JFrame();
	
	final int MAP_WIDTH = 900;
	final int MAP_HEIGHT = 600;
	final int ALL_WIDTH = 640;
	final int ALL_HEIGHT = 480;
	
	boolean firstStage = true;
	boolean secondStage = false;
	
	boolean movefront = false;
	boolean moveright = false;
	boolean moveleft = false;
	boolean moveback = false;
	boolean isTouched = false;
	boolean directionfront = false;
	boolean directionback = true;
	boolean directionright = false;
	boolean directionleft = false;
	boolean inventory = false;
	
	boolean cabinet_isopen = false;
	boolean broom_isclear = false;
	boolean sheet_isget = false;
	boolean glass_isget = false;
	boolean safe_ismessage = false;
	boolean safe_isopen = false;
	boolean drawer_right_isopen = false;
	boolean key_isget = false;
	boolean spoon_isget = false;
	boolean cabinet_hint_isget = false;
	boolean redlight_isget = false;
	boolean bluelight_isget = false;
	boolean greenlight_isget = false;
	boolean recipe_isget = false;
	boolean drug_isget = false;
	boolean door_hint_isget = false;
	boolean box_isopen = false;
	boolean red_marble_isget = false;
	boolean yellow_marble_isget = false;
	boolean black_marble_isget = false;
	boolean red_isget = false;
	boolean yellow_isget = false;
	boolean black_isget = false;
	boolean second_safe_isopen = false;
	boolean second_drawer_isopen = false;
	boolean machine_isopen = false;
	boolean sun_isget = false;
	boolean sun_button = false;
	boolean bag_isopen = false;
	boolean moon_isget = false;
	
	boolean char_init = false;
	
	boolean item1_info = false;
	boolean item2_info = false;
	boolean item3_info = false;
	boolean item4_info = false;
	boolean item5_info = false;
	boolean item6_info = false;
	boolean item7_info = false;
	
	boolean drawer_left = false;
	boolean drawer_right = false;
	
	boolean bookshelf_left = false;
	boolean bookshelf_right = false;
	
	boolean door_ismessage = false;
	boolean door_desert = false;
	boolean door_black = false;
	
	boolean lullaby_isget = false;
	
	boolean password_fail = false;
	
	boolean cushion_up = false;
	
	boolean kettle_sand = false;
	boolean kettle_lullaby = false;
	boolean kettle_dust = false;
	
	boolean machine_able = false;
	boolean blue = false;
	boolean red = false;
	boolean yellow = false;
	boolean green = false;
	boolean greenblue = false;
	boolean purple = false;
	boolean white = false;
	
	int charAni = 0;
	
	int inventory_x = 118;
	int inventory_y = 358;
	
	int times = 0;
	int char_x = 290;
	int char_y = 240;
	int background_x = -130;
	int background_y = -120;
	int inter_time = 0;
	int itemlist = 0;
	int machine_time = 0;
	
	int inventory_page = 1;
	
	int opening_count = 0;
	int ending_count = 0;
	
	int cabinet_correct[] = {8, 0, 1, 2};
	int safe_correct[] = {7, 2, 7, 5, 3, 5, 3};
	int drawer_correct[] = {1, 2, 5, 6, 4, 3};
	int second_safe_correct[] = {4, 2, 7, 9};
	int second_drawer_correct[] = {2, 6, 1, 4, 9, 0};
	int temp;
	
	int pattern = 0;
	
	int bag_pw1 = 0;
	int bag_pw2 = 0;
	int bag_pw3 = 0;
	int bag_pw4 = 0;
	int bag_pw5 = 0;
	int bag_pw6 = 0;
	int bag_pw7 = 0;
	int bag_pw8 = 0;
	
	Timer goChar;
	Timer goTime;
	
	ImageIcon intro_animation1 = new ImageIcon("src/image/intro_animations.gif");
	ImageIcon intro_animation2 = new ImageIcon("src/image/intro_animations2.gif");
	ImageIcon ending_animation1 = new ImageIcon("src/image/second_room_animation.gif");
	ImageIcon ending_animation2 = new ImageIcon("src/image/ending animation PART 1.gif");
	ImageIcon ending_animation3 = new ImageIcon("src/image/ending animation PART 2.gif");
	ImageIcon ending_animation4 = new ImageIcon("src/image/end.png");
	
	ImageIcon stage1 = new ImageIcon("src/image/stage1.png");
	ImageIcon stage2 = new ImageIcon("src/image/stage2.png");
	ImageIcon char1_back = new ImageIcon("src/image/char_back1.png");
	ImageIcon char2_back = new ImageIcon("src/image/char_back2.png");
	ImageIcon char3_back = new ImageIcon("src/image/char_back3.png");
	ImageIcon char4_back = new ImageIcon("src/image/char_back4.png");
	
	ImageIcon char1_front = new ImageIcon("src/image/char_front1.png");
	ImageIcon char2_front = new ImageIcon("src/image/char_front2.png");
	ImageIcon char3_front = new ImageIcon("src/image/char_front3.png");
	ImageIcon char4_front = new ImageIcon("src/image/char_front4.png");
	
	ImageIcon char1_right = new ImageIcon("src/image/char_right1.png");
	ImageIcon char2_right = new ImageIcon("src/image/char_right2.png");
	ImageIcon char3_right = new ImageIcon("src/image/char_right3.png");
	ImageIcon char4_right = new ImageIcon("src/image/char_right4.png");
	
	ImageIcon char1_left = new ImageIcon("src/image/char_left1.png");
	ImageIcon char2_left = new ImageIcon("src/image/char_left2.png");
	ImageIcon char3_left = new ImageIcon("src/image/char_left3.png");
	ImageIcon char4_left = new ImageIcon("src/image/char_left4.png");
	
	ImageIcon cabinet_detail = new ImageIcon("src/image/popup_detail_cabinet_hint.png");
	ImageIcon door_detail = new ImageIcon("src/image/popup_detail_door_hint.png");
	ImageIcon moon_detail = new ImageIcon("src/image/popup_detail_magic_moon.png");
	ImageIcon sun_detail = new ImageIcon("src/image/popup_detail_magic_sun.png");
	ImageIcon medicine_detail = new ImageIcon("src/image/popup_detail_medicine.png");
	ImageIcon sheet_detail = new ImageIcon("src/image/popup_detail_music_sheet.png");
	ImageIcon red_detail = new ImageIcon("src/image/popup_detail_red_light.png");
	ImageIcon green_detail = new ImageIcon("src/image/popup_detail_green_light.png");
	ImageIcon blue_detail = new ImageIcon("src/image/popup_detail_blue_light.png");
	ImageIcon drug_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon spoon_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon lullaby_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon glass_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon key_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon marble_black_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon marble_red_detail = new ImageIcon("src/image/itembutton1.png");
	ImageIcon marble_yellow_detail = new ImageIcon("src/image/itembutton1.png");
	
	ImageIcon inven = new ImageIcon("src/image/inven.png");
	
	ImageIcon glass_icon = new ImageIcon("src/image/Brownglass_Icon.png");
	ImageIcon glass_dust_icon = new ImageIcon("src/image/Brownglassindust_Icon.png");
	ImageIcon marble_black_icon = new ImageIcon("src/image/marble_black_icon.png");
	ImageIcon sheet_icon = new ImageIcon("src/image/paper_sheet_icon.png");
	ImageIcon paper1_icon = new ImageIcon("src/image/magicpaper_icon_sun.png");
	ImageIcon paper2_icon = new ImageIcon("src/image/magicpaper_icon_moon.png");
	ImageIcon lullaby_icon = new ImageIcon("src/image/mom_slullaby_Icon.png");
	ImageIcon key_icon = new ImageIcon("src/image/key_icon.png");
	ImageIcon marble_red_icon = new ImageIcon("src/image/marble_red_icon.png");
	ImageIcon marble_yellow_icon = new ImageIcon("src/image/marble_yellow_icon.png");
	ImageIcon spoon_icon = new ImageIcon("src/image/spoon_icon.png");
	ImageIcon spoon_sand_icon = new ImageIcon("src/image/spoon_sand_icon.png");
	ImageIcon redlight_icon = new ImageIcon("src/image/redlight_Icon.png");
	ImageIcon bluelight_icon = new ImageIcon("src/image/bluelight_Icon.png");
	ImageIcon greenlight_icon = new ImageIcon("src/image/greenlight_Icon.png");
	ImageIcon cabinet_icon = new ImageIcon("src/image/paper_cabinet_icon.png");
	ImageIcon recipe_icon = new ImageIcon("src/image/paper_medicine_icon.png");
	ImageIcon drug_icon = new ImageIcon("src/image/drug_icon.png");
	ImageIcon door_icon = new ImageIcon("src/image/paper_door_icon.png");
	
	ImageIcon popup_kettle = new ImageIcon("src/image/popup_kettle.png");
	ImageIcon popup_kettle_soup = new ImageIcon("src/image/popup_kettle_soup.png");
	ImageIcon popup_sofa = new ImageIcon("src/image/popup_sofa.png");
	ImageIcon popup_drawer = new ImageIcon("src/image/popup_drawer.png");
	ImageIcon popup_drawer_left = new ImageIcon("src/image/popup_drawer_left.png");
	ImageIcon popup_drawer_right = new ImageIcon("src/image/popup_drawer_right.png");
	ImageIcon popup_square_book = new ImageIcon("src/image/popup_sqdesk_book.png");
	ImageIcon popup_cabinet_close = new ImageIcon("src/image/popup_cabinet_close.png");
	ImageIcon popup_cabinet_open = new ImageIcon("src/image/popup_cabinet_open.png");
	ImageIcon popup_safe_close = new ImageIcon("src/image/popup_safe_close.png");
	ImageIcon popup_safe_open = new ImageIcon("src/image/popup_safe_open.png");
	ImageIcon popup_magic_book = new ImageIcon("src/image/popup_magic_book.png");
	ImageIcon popup_marimba = new ImageIcon("src/image/popup_marimba.png");
	ImageIcon popup_carpet = new ImageIcon("src/image/popup_carpet_no_paper.png");
	ImageIcon popup_carpet_paper = new ImageIcon("src/image/popup_carpet_paper.png");
	ImageIcon popup_door_basic = new ImageIcon("src/image/popup_door_basic.png");
	ImageIcon popup_door_desert = new ImageIcon("src/image/popup_door_desertworld.png");
	ImageIcon popup_door_black = new ImageIcon("src/image/popup_door_blackworld.png");
	ImageIcon popup_drawer_right_close = new ImageIcon("src/image/popup_drawer_right_close.png");
	ImageIcon popup_bookshelf = new ImageIcon("src/image/popup_bookshelf.png");
	ImageIcon popup_bookshelf_right = new ImageIcon("src/image/popup_bookshelf_right.png");
	ImageIcon popup_broom = new ImageIcon("src/image/popup_broom_dust.png");
	ImageIcon popup_broom_clear = new ImageIcon("src/image/popup_broom.png");
	ImageIcon popup_box_open = new ImageIcon("src/image/popup_box_open.png");
	ImageIcon popup_box_close = new ImageIcon("src/image/popup_box_close.png");
	ImageIcon popup_second_safe_close = new ImageIcon("src/image/popup_second_safe_close.png");
	ImageIcon popup_second_safe_open = new ImageIcon("src/image/popup_second_safe_open.png");
	ImageIcon popup_second_wrong = new ImageIcon("src/image/popup_second_safe_wrong.png");
	ImageIcon popup_second_drawer_close = new ImageIcon("src/image/popup_second_drawer_close.png");
	ImageIcon popup_second_drawer_open = new ImageIcon("src/image/popup_second_drawer_open.png");
	ImageIcon popup_machine_open = new ImageIcon("src/image/popup_light_machine_open.png");
	ImageIcon popup_machine_close = new ImageIcon("src/image/popup_light_machine_close.png");
	ImageIcon popup_bag_open = new ImageIcon("src/image/popup_bag_open.png");
	ImageIcon popup_bag_close = new ImageIcon("src/image/popup_bag_closed.png");
	
	ImageIcon popup_marble_black = new ImageIcon("src/image/popup_marble_black.png");
	ImageIcon popup_marble_red = new ImageIcon("src/image/popup_marble_red.png");
	ImageIcon popup_marble_yellow = new ImageIcon("src/image/popup_marble_yellow.png");
	
	ImageIcon popup_led_red = new ImageIcon("src/image/popup_button_led_red.png");
	
	ImageIcon bag_first0 = new ImageIcon("src/image/first/popup_button_first_0.png");
	ImageIcon bag_first1 = new ImageIcon("src/image/first/popup_button_first_1.png");
	ImageIcon bag_first2 = new ImageIcon("src/image/first/popup_button_first_2.png");
	ImageIcon bag_first3 = new ImageIcon("src/image/first/popup_button_first_3.png");
	ImageIcon bag_first4 = new ImageIcon("src/image/first/popup_button_first_4.png");
	ImageIcon bag_first5 = new ImageIcon("src/image/first/popup_button_first_5.png");
	ImageIcon bag_first6 = new ImageIcon("src/image/first/popup_button_first_6.png");
	ImageIcon bag_first7 = new ImageIcon("src/image/first/popup_button_first_7.png");
	ImageIcon bag_first8 = new ImageIcon("src/image/first/popup_button_first_8.png");
	ImageIcon bag_first9 = new ImageIcon("src/image/first/popup_button_first_9.png");
	
	ImageIcon bag_second0 = new ImageIcon("src/image/second/popup_button_second_0.png");
	ImageIcon bag_second1 = new ImageIcon("src/image/second/popup_button_second_1.png");
	ImageIcon bag_second2 = new ImageIcon("src/image/second/popup_button_second_2.png");
	ImageIcon bag_second3 = new ImageIcon("src/image/second/popup_button_second_3.png");
	ImageIcon bag_second4 = new ImageIcon("src/image/second/popup_button_second_4.png");
	ImageIcon bag_second5 = new ImageIcon("src/image/second/popup_button_second_5.png");
	ImageIcon bag_second6 = new ImageIcon("src/image/second/popup_button_second_6.png");
	ImageIcon bag_second7 = new ImageIcon("src/image/second/popup_button_second_7.png");
	ImageIcon bag_second8 = new ImageIcon("src/image/second/popup_button_second_8.png");
	ImageIcon bag_second9 = new ImageIcon("src/image/second/popup_button_second_9.png");
	
	ImageIcon bag_third0 = new ImageIcon("src/image/third/popup_button_third_0.png");
	ImageIcon bag_third1 = new ImageIcon("src/image/third/popup_button_third_1.png");
	ImageIcon bag_third2 = new ImageIcon("src/image/third/popup_button_third_2.png");
	ImageIcon bag_third3 = new ImageIcon("src/image/third/popup_button_third_3.png");
	ImageIcon bag_third4 = new ImageIcon("src/image/third/popup_button_third_4.png");
	ImageIcon bag_third5 = new ImageIcon("src/image/third/popup_button_third_5.png");
	ImageIcon bag_third6 = new ImageIcon("src/image/third/popup_button_third_6.png");
	ImageIcon bag_third7 = new ImageIcon("src/image/third/popup_button_third_7.png");
	ImageIcon bag_third8 = new ImageIcon("src/image/third/popup_button_third_8.png");
	ImageIcon bag_third9 = new ImageIcon("src/image/third/popup_button_third_9.png");
	
	ImageIcon bag_fourth0 = new ImageIcon("src/image/fourth/popup_button_fourth_0.png");
	ImageIcon bag_fourth1 = new ImageIcon("src/image/fourth/popup_button_fourth_1.png");
	ImageIcon bag_fourth2 = new ImageIcon("src/image/fourth/popup_button_fourth_2.png");
	ImageIcon bag_fourth3 = new ImageIcon("src/image/fourth/popup_button_fourth_3.png");
	ImageIcon bag_fourth4 = new ImageIcon("src/image/fourth/popup_button_fourth_4.png");
	ImageIcon bag_fourth5 = new ImageIcon("src/image/fourth/popup_button_fourth_5.png");
	ImageIcon bag_fourth6 = new ImageIcon("src/image/fourth/popup_button_fourth_6.png");
	ImageIcon bag_fourth7 = new ImageIcon("src/image/fourth/popup_button_fourth_7.png");
	ImageIcon bag_fourth8 = new ImageIcon("src/image/fourth/popup_button_fourth_8.png");
	ImageIcon bag_fourth9 = new ImageIcon("src/image/fourth/popup_button_fourth_9.png");
	
	ImageIcon bag_fifth0 = new ImageIcon("src/image/fifth/popup_button_fifth_0.png");
	ImageIcon bag_fifth1 = new ImageIcon("src/image/fifth/popup_button_fifth_1.png");
	ImageIcon bag_fifth2 = new ImageIcon("src/image/fifth/popup_button_fifth_2.png");
	ImageIcon bag_fifth3 = new ImageIcon("src/image/fifth/popup_button_fifth_3.png");
	ImageIcon bag_fifth4 = new ImageIcon("src/image/fifth/popup_button_fifth_4.png");
	ImageIcon bag_fifth5 = new ImageIcon("src/image/fifth/popup_button_fifth_5.png");
	ImageIcon bag_fifth6 = new ImageIcon("src/image/fifth/popup_button_fifth_6.png");
	ImageIcon bag_fifth7 = new ImageIcon("src/image/fifth/popup_button_fifth_7.png");
	ImageIcon bag_fifth8 = new ImageIcon("src/image/fifth/popup_button_fifth_8.png");
	ImageIcon bag_fifth9 = new ImageIcon("src/image/fifth/popup_button_fifth_9.png");
	
	ImageIcon bag_sixth0 = new ImageIcon("src/image/sixth/popup_button_sixth_0.png");
	ImageIcon bag_sixth1 = new ImageIcon("src/image/sixth/popup_button_sixth_1.png");
	ImageIcon bag_sixth2 = new ImageIcon("src/image/sixth/popup_button_sixth_2.png");
	ImageIcon bag_sixth3 = new ImageIcon("src/image/sixth/popup_button_sixth_3.png");
	ImageIcon bag_sixth4 = new ImageIcon("src/image/sixth/popup_button_sixth_4.png");
	ImageIcon bag_sixth5 = new ImageIcon("src/image/sixth/popup_button_sixth_5.png");
	ImageIcon bag_sixth6 = new ImageIcon("src/image/sixth/popup_button_sixth_6.png");
	ImageIcon bag_sixth7 = new ImageIcon("src/image/sixth/popup_button_sixth_7.png");
	ImageIcon bag_sixth8 = new ImageIcon("src/image/sixth/popup_button_sixth_8.png");
	ImageIcon bag_sixth9 = new ImageIcon("src/image/sixth/popup_button_sixth_9.png");
	
	ImageIcon bag_seventh0 = new ImageIcon("src/image/seventh/popup_button_seventh_0.png");
	ImageIcon bag_seventh1 = new ImageIcon("src/image/seventh/popup_button_seventh_1.png");
	ImageIcon bag_seventh2 = new ImageIcon("src/image/seventh/popup_button_seventh_2.png");
	ImageIcon bag_seventh3 = new ImageIcon("src/image/seventh/popup_button_seventh_3.png");
	ImageIcon bag_seventh4 = new ImageIcon("src/image/seventh/popup_button_seventh_4.png");
	ImageIcon bag_seventh5 = new ImageIcon("src/image/seventh/popup_button_seventh_5.png");
	ImageIcon bag_seventh6 = new ImageIcon("src/image/seventh/popup_button_seventh_6.png");
	ImageIcon bag_seventh7 = new ImageIcon("src/image/seventh/popup_button_seventh_7.png");
	ImageIcon bag_seventh8 = new ImageIcon("src/image/seventh/popup_button_seventh_8.png");
	ImageIcon bag_seventh9 = new ImageIcon("src/image/seventh/popup_button_seventh_9.png");
	
	ImageIcon bag_eighth0 = new ImageIcon("src/image/eighth/popup_button_eighth_0.png");
	ImageIcon bag_eighth1 = new ImageIcon("src/image/eighth/popup_button_eighth_1.png");
	ImageIcon bag_eighth2 = new ImageIcon("src/image/eighth/popup_button_eighth_2.png");
	ImageIcon bag_eighth3 = new ImageIcon("src/image/eighth/popup_button_eighth_3.png");
	ImageIcon bag_eighth4 = new ImageIcon("src/image/eighth/popup_button_eighth_4.png");
	ImageIcon bag_eighth5 = new ImageIcon("src/image/eighth/popup_button_eighth_5.png");
	ImageIcon bag_eighth6 = new ImageIcon("src/image/eighth/popup_button_eighth_6.png");
	ImageIcon bag_eighth7 = new ImageIcon("src/image/eighth/popup_button_eighth_7.png");
	ImageIcon bag_eighth8 = new ImageIcon("src/image/eighth/popup_button_eighth_8.png");
	ImageIcon bag_eighth9 = new ImageIcon("src/image/eighth/popup_button_eighth_9.png");
	
	JButton closebutton1 = new JButton(new ImageIcon("src/image/button1.png"));
	
	JButton itembutton1 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton itembutton2 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton itembutton3 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton itembutton4 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton itembutton5 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton itembutton6 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton itembutton7 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	
	JButton pagebutton_left = new JButton(new ImageIcon("src/image/pagebutton_left.png"));
	JButton pagebutton_right = new JButton(new ImageIcon("src/image/pagebutton_right.png"));
	
	JButton drawer_button_left = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton drawer_button_right = new JButton(new ImageIcon("src/image/itembutton1.png"));
	
	JButton bookshelf_button_left = new JButton(new ImageIcon("src/image/popup_button_bookshelf_left.png"));
	JButton bookshelf_button_right = new JButton(new ImageIcon("src/image/itembutton1.png"));
	
	JButton door_change1 = new JButton(new ImageIcon("src/image/popup_button_door_change.png"));
	JButton door_change2 = new JButton(new ImageIcon("src/image/popup_button_door_change.png"));
	JButton door_change3 = new JButton(new ImageIcon("src/image/popup_button_door_change.png"));
	JButton door_ok = new JButton(new ImageIcon("src/image/popup_button_door_ok.png"));
	
	JButton carpet_button = new JButton(new ImageIcon("src/image/popup_button_carpet_coin.png"));
	JButton lullaby_button = new JButton(new ImageIcon("src/image/popup_button_lullaby.png"));
	JButton music_button = new JButton(new ImageIcon("src/image/popup_button_music sheet.png"));
	JButton key_button = new JButton(new ImageIcon("src/image/popup_button_key.png"));
	JButton red_marble = new JButton(new ImageIcon("src/image/popup_button_red marble.png"));
	JButton cushion = new JButton(new ImageIcon("src/image/popup_button_cushion.png"));
	JButton spoon = new JButton(new ImageIcon("src/image/popup_button_spoon.png"));
	JButton cabinet_hint = new JButton(new ImageIcon("src/image/popup_button_cabinet_hint.png"));
	JButton red_light = new JButton(new ImageIcon("src/image/popup_button_redlight.png"));
	JButton blue_light = new JButton(new ImageIcon("src/image/popup_button_blue light.png"));
	JButton green_light = new JButton(new ImageIcon("src/image/popup_button_green_light.png"));
	JButton door_recipe = new JButton(new ImageIcon("src/image/popup_button_recipe.png"));
	JButton dust_button = new JButton(new ImageIcon("src/image/popup_button_dust.png"));
	JButton door_hint = new JButton(new ImageIcon("src/image/popup_button_door_hint.png"));
	JButton gori = new JButton(new ImageIcon("src/image/popup_button_gori.png"));
	JButton yellow_marble = new JButton(new ImageIcon("src/image/popup_button_yellow_marble.png"));
	JButton sun = new JButton(new ImageIcon("src/image/popup_magic coin_sun.png"));
	JButton moon = new JButton(new ImageIcon("src/image/popup_magic coin_moon.png"));
	JButton machine_red_button = new JButton(new ImageIcon("src/image/popup_machine_red_light.png"));
	JButton machine_blue_button = new JButton(new ImageIcon("src/image/popup_machine_blue_light.png"));
	JButton machine_green_button = new JButton(new ImageIcon("src/image/popup_machine_green_light.png"));
	
	JButton popup_button_0 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_1 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_2 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_3 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_4 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_5 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_6 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_7 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_8 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_9 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_ok = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_x = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_10 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	JButton popup_button_11 = new JButton(new ImageIcon("src/image/itembutton1.png"));
	
	JButton bag_button_1 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_2 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_3 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_4 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_5 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_6 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_7 = new JButton(new ImageIcon("src/image/bag_button1.png"));
	JButton bag_button_8 = new JButton(new ImageIcon("src/image/bag_button2.png"));
	
	Object kettle = new Object("src/image/kettle.png", 412, 144, 110, 115);
	Object kettle_soup = new Object("src/image/kettle_soup.png", 412, 144, 110, 115);
	
	Object bookshelf = new Object("src/image/bookshelf.png", 587, -56, 151, 169);
	
	Object drawer = new Object("src/image/drawer.png", 665, 168, 83, 191);
	
	Object sofa = new Object("src/image/sofa.png", -106, 195, 110, 217);
	
	Object box = new Object("src/image/box.png", 701, 93, 46, 75);
	
	Object round_desk = new Object("src/image/round_desk.png", 78, 220, 130, 128);	
	Object round_desk_sheet = new Object("src/image/round_desk_sheet.png", 78, 220, 130, 128);	
	
	Object square_desk = new Object("src/image/square_desk.png", 15, -18, 211, 146);
	
	Object broom_dust = new Object("src/image/broom_dust.png", 698, 288, 46, 116);
	Object broom = new Object("src/image/broom.png", 698, 288, 46, 116);
	
	Object cabinet_close_glass = new Object("src/image/cabinet_close_glass.png", -92, -68, 110, 193);
	Object cabinet_close = new Object("src/image/cabinet_close.png", -92, -68, 110, 193);
	Object cabinet_open_glass = new Object("src/image/cabinet_open_glass.png", -92, -68, 110, 193);
	Object cabinet_open = new Object("src/image/cabinet_open.png", -92, -68, 110, 193);
	
	Object marimba = new Object("src/image/marimba.png", 436, -1, 148, 107);
	
	Object marble_black = new Object("src/image/marble_black.png", 298, -51, 24, 24);
	Object marble_yellow = new Object("src/image/marble_yellow.png", 273, -5, 24, 24);
	Object marble_red = new Object("src/image/marble_red.png", 323, -5, 24, 24);
	
	Object magic_paper1 = new Object("src/image/magic_paper1.png", 220, 371, 17, 11);
	
	Object second_safe = new Object("src/image/second_safe.png", -6, 224, 63, 78);
	Object second_drawer = new Object("src/image/second_drawer.png", 649, -36, 47, 111);
	Object bag = new Object("src/image/black_bag.png", -97, 19, 38, 36);
	
	Object machine = new Object("src/image/light_machine_basic.png", 287, 127, 66, 119);
	Object machine_blue = new Object("src/image/light_machine_blue.png", 247, -69, 145, 315);
	Object machine_green = new Object("src/image/light_machine_green.png", 247, -69, 145, 315);
	Object machine_greenblue = new Object("src/image/light_machine_greenblue.png", 247, -69, 145, 315);
	Object machine_purple = new Object("src/image/light_machine_purple.png", 247, -69, 145, 315);
	Object machine_red = new Object("src/image/light_machine_red.png", 247, -69, 145, 315);
	Object machine_white = new Object("src/image/light_machine_white.png", 247, -69, 145, 315);
	Object machine_yellow = new Object("src/image/light_machine_yellow.png", 247, -69, 145, 315);
	
	Object magic_pattern1 = new Object("src/image/magic_pattern1.png", 180, 124, 281, 212);
	Object magic_pattern2 = new Object("src/image/magic_pattern2.png", 180, 124, 281, 212);
	Object magic_pattern3 = new Object("src/image/magic_pattern3.png", 180, 124, 281, 212);
	
	Stack stack = new Stack();
	
	ArrayList<ImageIcon> generalChar_back;
	ArrayList<ImageIcon> generalChar_front;
	ArrayList<ImageIcon> generalChar_right;
	ArrayList<ImageIcon> generalChar_left;
	
	ArrayList<ImageIcon> inventory_list;
	ArrayList<ImageIcon> item_information;
	
	ArrayList<ImageIcon> door_marble;
	
	ArrayList<ImageIcon> bag_button_first;
	ArrayList<ImageIcon> bag_button_second;
	ArrayList<ImageIcon> bag_button_third;
	ArrayList<ImageIcon> bag_button_fourth;
	ArrayList<ImageIcon> bag_button_fifth;
	ArrayList<ImageIcon> bag_button_sixth;
	ArrayList<ImageIcon> bag_button_seventh;
	ArrayList<ImageIcon> bag_button_eighth;
	
	JLayeredPane lp = new JLayeredPane();
	GamePanel gamepanel = new GamePanel();
	GamePanel2 gamepanel2 = new GamePanel2();
	StartPanel startpanel = new StartPanel();
	
	public static void main(String[] args)
	{
		MainFrame myframe = new MainFrame();
		myframe.start();
	}
	
	public void start()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lp.add(startpanel, new Integer(2)); //오프닝
		startpanel.setSize(MAP_WIDTH, MAP_HEIGHT);
		lp.add(gamepanel, new Integer(1)); //첫번째 방 						
		gamepanel.setSize(MAP_WIDTH, MAP_HEIGHT);
		lp.add(gamepanel2, new Integer(0)); // 두번째 방 						
		gamepanel2.setSize(MAP_WIDTH, MAP_HEIGHT); //게임 사이즈
		frame.add(lp);
		frame.setTitle("E.S.cape"); // 제목
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(ALL_WIDTH, ALL_HEIGHT);
		frame.setLocation(1000, 100);
		
		generalChar_back = new ArrayList<ImageIcon>(); //캐릭터 움직임
		{
			generalChar_back.add(char1_back);
			generalChar_back.add(char2_back);
			generalChar_back.add(char3_back);
			generalChar_back.add(char4_back);
		}
		generalChar_front = new ArrayList<ImageIcon>();//캐릭터 움직임
		{
			generalChar_front.add(char1_front);
			generalChar_front.add(char2_front);
			generalChar_front.add(char3_front);
			generalChar_front.add(char4_front);
		}
		generalChar_right = new ArrayList<ImageIcon>();//캐릭터 움직임
		{
			generalChar_right.add(char1_right);
			generalChar_right.add(char2_right);
			generalChar_right.add(char3_right);
			generalChar_right.add(char4_right);
		}
		generalChar_left = new ArrayList<ImageIcon>();//캐릭터 움직임
		{
			generalChar_left.add(char1_left);
			generalChar_left.add(char2_left);
			generalChar_left.add(char3_left);
			generalChar_left.add(char4_left);
		}
		
		door_marble = new ArrayList<ImageIcon>(); //벽에 있는 구슬
		{
			door_marble.add(popup_marble_yellow);
			door_marble.add(popup_marble_red);
			door_marble.add(popup_marble_black);
			door_marble.add(popup_marble_black);
		}
		inventory_list = new ArrayList<ImageIcon>();{} //인벤토리 리스트
		item_information = new ArrayList<ImageIcon>();{} // 상세정보
		
		bag_button_first = new ArrayList<ImageIcon>(); //두번째 방 가방 버튼
		{
			bag_button_first.add(bag_first0);
			bag_button_first.add(bag_first1);
			bag_button_first.add(bag_first2);
			bag_button_first.add(bag_first3);
			bag_button_first.add(bag_first4);
			bag_button_first.add(bag_first5);
			bag_button_first.add(bag_first6);
			bag_button_first.add(bag_first7);
			bag_button_first.add(bag_first8);
			bag_button_first.add(bag_first9);
		}
		bag_button_second = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_second.add(bag_second0);
			bag_button_second.add(bag_second1);
			bag_button_second.add(bag_second2);
			bag_button_second.add(bag_second3);
			bag_button_second.add(bag_second4);
			bag_button_second.add(bag_second5);
			bag_button_second.add(bag_second6);
			bag_button_second.add(bag_second7);
			bag_button_second.add(bag_second8);
			bag_button_second.add(bag_second9);
		}
		bag_button_third = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_third.add(bag_third0);
			bag_button_third.add(bag_third1);
			bag_button_third.add(bag_third2);
			bag_button_third.add(bag_third3);
			bag_button_third.add(bag_third4);
			bag_button_third.add(bag_third5);
			bag_button_third.add(bag_third6);
			bag_button_third.add(bag_third7);
			bag_button_third.add(bag_third8);
			bag_button_third.add(bag_third9);
		}
		bag_button_fourth = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_fourth.add(bag_fourth0);
			bag_button_fourth.add(bag_fourth1);
			bag_button_fourth.add(bag_fourth2);
			bag_button_fourth.add(bag_fourth3);
			bag_button_fourth.add(bag_fourth4);
			bag_button_fourth.add(bag_fourth5);
			bag_button_fourth.add(bag_fourth6);
			bag_button_fourth.add(bag_fourth7);
			bag_button_fourth.add(bag_fourth8);
			bag_button_fourth.add(bag_fourth9);
		}
		bag_button_fifth = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_fifth.add(bag_fifth0);
			bag_button_fifth.add(bag_fifth1);
			bag_button_fifth.add(bag_fifth2);
			bag_button_fifth.add(bag_fifth3);
			bag_button_fifth.add(bag_fifth4);
			bag_button_fifth.add(bag_fifth5);
			bag_button_fifth.add(bag_fifth6);
			bag_button_fifth.add(bag_fifth7);
			bag_button_fifth.add(bag_fifth8);
			bag_button_fifth.add(bag_fifth9);
		}
		bag_button_sixth = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_sixth.add(bag_sixth0);
			bag_button_sixth.add(bag_sixth1);
			bag_button_sixth.add(bag_sixth2);
			bag_button_sixth.add(bag_sixth3);
			bag_button_sixth.add(bag_sixth4);
			bag_button_sixth.add(bag_sixth5);
			bag_button_sixth.add(bag_sixth6);
			bag_button_sixth.add(bag_sixth7);
			bag_button_sixth.add(bag_sixth8);
			bag_button_sixth.add(bag_sixth9);
		}
		bag_button_seventh = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_seventh.add(bag_seventh0);
			bag_button_seventh.add(bag_seventh1);
			bag_button_seventh.add(bag_seventh2);
			bag_button_seventh.add(bag_seventh3);
			bag_button_seventh.add(bag_seventh4);
			bag_button_seventh.add(bag_seventh5);
			bag_button_seventh.add(bag_seventh6);
			bag_button_seventh.add(bag_seventh7);
			bag_button_seventh.add(bag_seventh8);
			bag_button_seventh.add(bag_seventh9);
		}
		bag_button_eighth = new ArrayList<ImageIcon>();//두번째 방 가방 버튼
		{
			bag_button_eighth.add(bag_eighth0);
			bag_button_eighth.add(bag_eighth1);
			bag_button_eighth.add(bag_eighth2);
			bag_button_eighth.add(bag_eighth3);
			bag_button_eighth.add(bag_eighth4);
			bag_button_eighth.add(bag_eighth5);
			bag_button_eighth.add(bag_eighth6);
			bag_button_eighth.add(bag_eighth7);
			bag_button_eighth.add(bag_eighth8);
			bag_button_eighth.add(bag_eighth9);
		}
		
		goChar = new Timer(25, new CharacterListener()); //1초에 40프레임
		goTime = new Timer(30,new ClockListener()); //타이머
		
		gamepanel.addKeyListener(new DirectionListener()); //캐릭터 이동 리스너
		gamepanel2.addKeyListener(new DirectionListener()); //캐릭터 이동 리스너
		closebutton1.addMouseListener(new closeListener1()); //버튼 리스너
		
		itembutton1.addMouseListener(new itemInfoListener1());
		itembutton2.addMouseListener(new itemInfoListener2());
		itembutton3.addMouseListener(new itemInfoListener3());
		itembutton4.addMouseListener(new itemInfoListener4());
		itembutton5.addMouseListener(new itemInfoListener5());
		itembutton6.addMouseListener(new itemInfoListener6());
		itembutton7.addMouseListener(new itemInfoListener7());
		
		pagebutton_left.addMouseListener(new leftListener());
		pagebutton_right.addMouseListener(new rightListener());
		
		drawer_button_left.addMouseListener(new drawerleftListener());
		drawer_button_right.addMouseListener(new drawerrightListener());
		
		carpet_button.addMouseListener(new carpetListener());
		
		door_change1.addMouseListener(new change1Listener());
		door_change2.addMouseListener(new change2Listener());
		door_change3.addMouseListener(new change3Listener());
		door_ok.addMouseListener(new okListener());
		
		popup_button_0.addMouseListener(new keypad0Listener());
		popup_button_1.addMouseListener(new keypad1Listener());
		popup_button_2.addMouseListener(new keypad2Listener());
		popup_button_3.addMouseListener(new keypad3Listener());
		popup_button_4.addMouseListener(new keypad4Listener());
		popup_button_5.addMouseListener(new keypad5Listener());
		popup_button_6.addMouseListener(new keypad6Listener());
		popup_button_7.addMouseListener(new keypad7Listener());
		popup_button_8.addMouseListener(new keypad8Listener());
		popup_button_9.addMouseListener(new keypad9Listener());
		popup_button_ok.addMouseListener(new keypadokListener());
		popup_button_x.addMouseListener(new keypadxListener());
		popup_button_10.addMouseListener(new keypad10Listener());
		popup_button_11.addMouseListener(new keypad11Listener());
		
		lullaby_button.addMouseListener(new lullabyListener());
		music_button.addMouseListener(new musicListener());
		key_button.addMouseListener(new keyListener());
		red_marble.addMouseListener(new redListener());
		cushion.addMouseListener(new cushionListener());
		
		bookshelf_button_left.addMouseListener(new bookleftListener());
		bookshelf_button_right.addMouseListener(new bookrightListener());
		
		spoon.addMouseListener(new spoonListener());
		cabinet_hint.addMouseListener(new cabihintListener());
		red_light.addMouseListener(new redlightListener());
		blue_light.addMouseListener(new bluelightListener());
		green_light.addMouseListener(new greenlightListener());
		door_recipe.addMouseListener(new recipeListener());
		dust_button.addMouseListener(new dustListener());
		door_hint.addMouseListener(new doorListener());
		gori.addMouseListener(new goriListener());
		yellow_marble.addMouseListener(new yellowListener());
		sun.addMouseListener(new sunListener());
		moon.addMouseListener(new moonListener());
		machine_red_button.addMouseListener(new redlightListener());
		machine_blue_button.addMouseListener(new bluelightListener());
		machine_green_button.addMouseListener(new greenlightListener());
		
		bag_button_1.addMouseListener(new bag1Listener());
		bag_button_2.addMouseListener(new bag2Listener());
		bag_button_3.addMouseListener(new bag3Listener());
		bag_button_4.addMouseListener(new bag4Listener());
		bag_button_5.addMouseListener(new bag5Listener());
		bag_button_6.addMouseListener(new bag6Listener());
		bag_button_7.addMouseListener(new bag7Listener());
		bag_button_8.addMouseListener(new bag8Listener());
	}
	
	private class ClockListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			times++; //게임을 시작했을 때부터 시간을 셈
		}
	}
	
	
	public class CharacterListener implements ActionListener
	{
		public void actionPerformed (ActionEvent arg0)
		{
			if(firstStage == true)
			{
				kettle.isTouched(char_x, char_y); //각 장애물에 충돌 되었는지 반환함
				bookshelf.isTouched(char_x, char_y);
				drawer.isTouched(char_x, char_y);
				sofa.isTouched(char_x, char_y);
				box.isTouched(char_x, char_y);
				round_desk_sheet.isTouched(char_x, char_y);
				square_desk.isTouched(char_x, char_y);
				broom_dust.isTouched(char_x, char_y);
				cabinet_close_glass.isTouched(char_x, char_y);
				marble_black.isTouched(char_x, char_y);
				marble_yellow.isTouched(char_x, char_y);
				marble_red.isTouched(char_x, char_y);
				magic_paper1.isTouched(char_x, char_y);
				cabinet_close.isTouched(char_x, char_y);
				cabinet_open_glass.isTouched(char_x, char_y);
				cabinet_open.isTouched(char_x, char_y);
				broom.isTouched(char_x, char_y);
				round_desk.isTouched(char_x, char_y);
				kettle_soup.isTouched(char_x, char_y);
				marimba.isTouched(char_x, char_y);
	
				if(movefront == true || moveright == true || moveleft == true || moveback == true)
				{
					charAni++;
					if(charAni / 10 == 4) //캐릭터 움직임 출력
					{
						charAni = 0;
					}
				}
				else
				{
					charAni = 0; //캐릭터 움직임 멈춤
				}
				
				if(movefront == true) //앞으로 갈 때
				{
					directionback = false;
					directionright = false;
					directionleft = false;
					directionfront = true;
					
					if(background_y <= 6 && kettle.backtouched == true) // 각 장애물에 충돌했을 때
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && bookshelf.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && drawer.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && sofa.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && box.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && round_desk_sheet.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && square_desk.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && broom_dust.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && cabinet_close_glass.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && marble_black.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && marble_yellow.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && marble_red.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && marimba.backtouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y <= 0 && char_y < 240) //카메라 움직임
					{
						background_y += 6;
						kettle.y += 6;
						bookshelf.y += 6;
						drawer.y += 6;
						sofa.y += 6;
						box.y += 6;
						round_desk_sheet.y += 6;
						square_desk.y += 6;
						broom_dust.y += 6;
						cabinet_close_glass.y += 6;
						marble_black.y += 6;
						marble_yellow.y += 6;
						marble_red.y += 6;
						magic_paper1.y += 6;
						cabinet_close.y += 6;
						cabinet_open_glass.y += 6;
						cabinet_open.y += 6;
						broom.y += 6;
						round_desk.y += 6;
						kettle_soup.y += 6;
						marimba.y += 6;
						char_y += 0;
					}
					else if(char_y < 120) //캐릭터 움직임
					{
						char_y += 0;
					}
					else
					{
						char_y -= 6;
					}
				}
				else if(moveback == true)
				{
					directionfront = false;
					directionright = false;
					directionleft = false;
					directionback = true;
					
					if(background_y >= -132 && kettle.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && bookshelf.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && drawer.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && sofa.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && box.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && round_desk_sheet.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && square_desk.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && broom_dust.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && cabinet_close_glass.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && marble_black.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && marble_yellow.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && marble_red.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && marimba.fronttouched == true)
					{
						background_y += 0;
						kettle.y += 0;
						bookshelf.y += 0;
						drawer.y += 0;
						sofa.y += 0;
						box.y += 0;
						round_desk_sheet.y += 0;
						square_desk.y += 0;
						broom_dust.y += 0;
						cabinet_close_glass.y += 0;
						marble_black.y += 0;
						marble_yellow.y += 0;
						marble_red.y += 0;
						magic_paper1.y += 0;
						cabinet_close.y += 0;
						cabinet_open_glass.y += 0;
						cabinet_open.y += 0;
						broom.y += 0;
						round_desk.y += 0;
						kettle_soup.y += 0;
						marimba.y += 0;
						char_y += 0;
					}
					else if(background_y > -120 && char_y > 240)
					{
						background_y -= 6;
						kettle.y -= 6;
						bookshelf.y -= 6;
						drawer.y -= 6;
						sofa.y -= 6;
						box.y -= 6;
						round_desk_sheet.y -= 6;
						square_desk.y -= 6;
						broom_dust.y -= 6;
						cabinet_close_glass.y -= 6;
						marble_black.y -= 6;
						marble_yellow.y -= 6;
						marble_red.y -= 6;
						magic_paper1.y -= 6;
						cabinet_close.y -= 6;
						cabinet_open_glass.y -= 6;
						cabinet_open.y -= 6;
						broom.y -= 6;
						round_desk.y -= 6;
						kettle_soup.y -= 6;
						marimba.y -= 6;
						char_y += 0;
					}
					else if(char_y > 315)
					{
						char_y += 0;
					}
					else
					{
						char_y += 6;
					}
				}
				if(moveright == true)
				{
					directionfront = false;
					directionback = false;
					directionright = false;
					directionleft = true;
					
					if(background_x >= -265 && kettle.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && bookshelf.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && drawer.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && sofa.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && box.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && round_desk_sheet.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && square_desk.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && broom_dust.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && cabinet_close_glass.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && marble_black.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && marble_yellow.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && marble_red.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && marimba.lefttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x > -260 && char_x > 320)
					{
						background_x -= 6;
						kettle.x -= 6;
						bookshelf.x -= 6;
						drawer.x -= 6;
						sofa.x -= 6;
						box.x -= 6;
						round_desk_sheet.x -= 6;
						square_desk.x -= 6;
						broom_dust.x -= 6;
						cabinet_close_glass.x -= 6;
						marble_black.x -= 6;
						marble_yellow.x -= 6;
						marble_red.x -= 6;
						magic_paper1.x -= 6;
						cabinet_close.x -= 6;
						cabinet_open_glass.x -= 6;
						cabinet_open.x -= 6;
						broom.x -= 6;
						round_desk.x -= 6;
						kettle_soup.x -= 6;
						marimba.x -= 6;
						char_x += 0;
					}
					else if(char_x > 550)
					{
						char_x += 0;
					}
					else
					{
						char_x += 6;
					}
				}
				else if(moveleft == true)
				{
					directionfront = false;
					directionback = false;
					directionleft = false;
					directionright = true;
					
					
					if(background_x < 5 && kettle.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && bookshelf.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && drawer.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && sofa.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && box.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && round_desk_sheet.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && square_desk.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && broom_dust.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && cabinet_close_glass.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && marble_black.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && marble_yellow.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && marble_red.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && marimba.righttouched == true)
					{
						background_x += 0;
						kettle.x += 0;
						bookshelf.x += 0;
						drawer.x += 0;
						sofa.x += 0;
						box.x += 0;
						round_desk_sheet.x += 0;
						square_desk.x += 0;
						broom_dust.x += 0;
						cabinet_close_glass.x += 0;
						marble_black.x += 0;
						marble_yellow.x += 0;
						marble_red.x += 0;
						magic_paper1.x += 0;
						cabinet_close.x += 0;
						cabinet_open_glass.x += 0;
						cabinet_open.x += 0;
						broom.x += 0;
						round_desk.x += 0;
						kettle_soup.x += 0;
						marimba.x += 0;
						char_x += 0;
					}
					else if(background_x < 0 && char_x < 320)
					{
						background_x += 6;
						kettle.x += 6;
						bookshelf.x += 6;
						drawer.x += 6;
						sofa.x += 6;
						box.x += 6;
						round_desk_sheet.x += 6;
						square_desk.x += 6;
						broom_dust.x += 6;
						cabinet_close_glass.x += 6;
						marble_black.x += 6;
						marble_yellow.x += 6;
						marble_red.x += 6;
						magic_paper1.x += 6;
						cabinet_close.x += 6;
						cabinet_open_glass.x += 6;
						cabinet_open.x += 6;
						broom.x += 6;
						round_desk.x += 6;
						kettle_soup.x += 6;
						marimba.x += 6;
						char_x += 0;
					}
					else if(char_x < 30)
					{
						char_x += 0;
					}
					else
					{
						char_x -= 6;
					}
				}
			}
			else if(secondStage == true) //두번째 방
			{
				second_safe.isTouched(char_x, char_y);
				second_drawer.isTouched(char_x, char_y);
				bag.isTouched(char_x, char_y);
				machine.isTouched(char_x, char_y);
				machine_blue.isTouched(char_x, char_y);
				machine_red.isTouched(char_x, char_y);
				machine_yellow.isTouched(char_x, char_y);
				machine_green.isTouched(char_x, char_y);
				machine_greenblue.isTouched(char_x, char_y);
				machine_purple.isTouched(char_x, char_y);
				machine_white.isTouched(char_x, char_y);
				
				if(movefront == true || moveright == true || moveleft == true || moveback == true)
				{
					charAni++;
					if(charAni / 10 == 4)
					{
						charAni = 0;
					}
				}
				else
				{
					charAni = 0;
				}
				
				if(movefront == true)
				{
					directionback = false;
					directionright = false;
					directionleft = false;
					directionfront = true;
					
					if(background_y <= 6 && second_safe.backtouched == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && second_drawer.backtouched == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && bag.backtouched == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y <= 6 && machine.backtouched == true && machine_able == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y <= 0 && char_y < 240)
					{
						background_y += 6;
						second_safe.y += 6;
						second_drawer.y += 6;
						bag.y += 6;
						machine.y += 6;
						machine_blue.y += 6;
						machine_green.y += 6;
						machine_greenblue.y += 6;
						machine_red.y += 6;
						machine_white.y += 6;
						machine_purple.y += 6;
						machine_yellow.y += 6;
						magic_pattern1.y += 6;
						magic_pattern2.y += 6;
						magic_pattern3.y += 6;
						char_y += 0;
					}
					else if(char_y < 120)
					{
						char_y += 0;
					}
					else
					{
						char_y -= 6;
					}
					
				}
				else if(moveback == true)
				{
					directionfront = false;
					directionright = false;
					directionleft = false;
					directionback = true;
					
					if(background_y >= -132 && second_safe.fronttouched == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && second_drawer.fronttouched == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && bag.fronttouched == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y >= -132 && machine.fronttouched == true && machine_able == true)
					{
						background_y += 0;
						second_safe.y += 0;
						second_drawer.y += 0;
						bag.y += 0;
						machine.y += 0;
						machine_blue.y += 0;
						machine_green.y += 0;
						machine_greenblue.y += 0;
						machine_red.y += 0;
						machine_white.y += 0;
						machine_purple.y += 0;
						machine_yellow.y += 0;
						magic_pattern1.y += 0;
						magic_pattern2.y += 0;
						magic_pattern3.y += 0;
						char_y += 0;
					}
					else if(background_y > -120 && char_y > 240)
					{
						background_y -= 6;
						second_safe.y -= 6;
						second_drawer.y -= 6;
						bag.y -= 6;
						machine.y -= 6;
						machine_blue.y -= 6;
						machine_green.y -= 6;
						machine_greenblue.y -= 6;
						machine_red.y -= 6;
						machine_white.y -= 6;
						machine_purple.y -= 6;
						machine_yellow.y -= 6;
						magic_pattern1.y -= 6;
						magic_pattern2.y -= 6;
						magic_pattern3.y -= 6;
						char_y += 0;
					}
					else if(char_y > 315)
					{
						char_y += 0;
					}
					else
					{
						char_y += 6;
					}
				}
				
				if(moveright == true)
				{
					directionfront = false;
					directionback = false;
					directionright = false;
					directionleft = true;
					
					if(background_x >= -265 && second_safe.lefttouched == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && second_drawer.lefttouched == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && bag.lefttouched == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x >= -265 && machine.lefttouched == true && machine_able == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x > -260 && char_x > 320)
					{
						background_x -= 6;
						second_safe.x -= 6;
						second_drawer.x -= 6;
						bag.x -= 6;
						machine.x -= 6;
						machine_blue.x -= 6;
						machine_green.x -= 6;
						machine_greenblue.x -= 6;
						machine_red.x -= 6;
						machine_white.x -= 6;
						machine_purple.x -= 6;
						machine_yellow.x -= 6;
						magic_pattern1.x -= 6;
						magic_pattern2.x -= 6;
						magic_pattern3.x -= 6;
						char_x += 0;
					}
					else if(char_x > 550)
					{
						char_x += 0;
					}
					else
					{
						char_x += 6;
					}
				}
				else if(moveleft == true)
				{
					directionfront = false;
					directionback = false;
					directionleft = false;
					directionright = true;
					
					if(background_x < 5 && second_safe.righttouched == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && second_drawer.righttouched == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && bag.righttouched == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x < 5 && machine.righttouched == true && machine_able == true)
					{
						background_x += 0;
						second_safe.x += 0;
						second_drawer.x += 0;
						bag.x += 0;
						machine.x += 0;
						machine_blue.x += 0;
						machine_green.x += 0;
						machine_greenblue.x += 0;
						machine_red.x += 0;
						machine_white.x += 0;
						machine_purple.x += 0;
						machine_yellow.x += 0;
						magic_pattern1.x += 0;
						magic_pattern2.x += 0;
						magic_pattern3.x += 0;
						char_x += 0;
					}
					else if(background_x < 0 && char_x < 320)
					{
						background_x += 6;
						second_safe.x += 6;
						second_drawer.x += 6;
						bag.x += 6;
						machine.x += 6;
						machine_blue.x += 6;
						machine_green.x += 6;
						machine_greenblue.x += 6;
						machine_red.x += 6;
						machine_white.x += 6;
						machine_purple.x += 6;
						machine_yellow.x += 6;
						magic_pattern1.x += 6;
						magic_pattern2.x += 6;
						magic_pattern3.x += 6;
						char_x += 0;
					}
					else if(char_x < 30)
					{
						char_x += 0;
					}
					else
					{
						char_x -= 6;
					}
				}
				
				//두번째 방 기계
				if(machine_able == true && redlight_isget == true && bluelight_isget == true && greenlight_isget == true)
				{
					blue = false;
					red = false;
					green = false;
					yellow = false;
					greenblue = false;
					purple = false;
					white = false;
				}
				else if(machine_able == true && redlight_isget == false && bluelight_isget == true && greenlight_isget == true)
				{
					blue = false;
					red = true;
					green = false;
					yellow = false;
					greenblue = false;
					purple = false;
					white = false;
				}
				else if(machine_able == true && redlight_isget == true && bluelight_isget == false && greenlight_isget == true)
				{
					blue = true;
					red = false;
					green = false;
					yellow = false;
					greenblue = false;
					purple = false;
					white = false;
				}
				else if(machine_able == true && redlight_isget == true && bluelight_isget == true && greenlight_isget == false)
				{
					blue = false;
					red = false;
					green = true;
					yellow = false;
					greenblue = false;
					purple = false;
					white = false;
				}
				else if(machine_able == true && redlight_isget == false && bluelight_isget == true && greenlight_isget == false)
				{
					blue = false;
					red = false;
					green = false;
					yellow = true;
					greenblue = false;
					purple = false;
					white = false;
				}
				else if(machine_able == true && redlight_isget == false && bluelight_isget == false && greenlight_isget == true)
				{
					blue = false;
					red = false;
					green = false;
					yellow = false;
					greenblue = false;
					purple = true;
					white = false;
				}
				else if(machine_able == true && redlight_isget == true && bluelight_isget == false && greenlight_isget == false)
				{
					blue = false;
					red = false;
					green = false;
					yellow = false;
					greenblue = true;
					purple = false;
					white = false;
				}
				else if(machine_able == true && redlight_isget == false && bluelight_isget == false && greenlight_isget == false)
				{
					blue = false;
					red = false;
					green = false;
					yellow = false;
					greenblue = false;
					purple = false;
					white = true;
				}
			}
			
			if(char_init == true) //캐릭터 위치 초기화(방 이동할 때)
			{
				char_x = 290;
				char_y = 240;
				background_x = -130;
				background_y = -120;
				
				char_init = false;
			}
		}
	}
	
	public class StartPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
			
			startpanel.setLayout(null);
			if(opening_count <= 6400) //인트로 애니메이션 출력
			{
				g.drawImage(intro_animation1.getImage(), 0, -30, 640, 480, this);
			}
			else if(opening_count > 6400 && opening_count < 11600)
			{
				g.drawImage(intro_animation2.getImage(), 0, -30, 640, 480, this);
			}
			else if(opening_count == 11600)
			{
				firstStage = true; //끝나면 첫번째 방 출력
				lp.setLayer(gamepanel, 3);
				gamepanel.setFocusable(true);
				gamepanel.requestFocus();
			}
			
			if(opening_count <= 12000)
			{
				opening_count++;
			}
			
			frame.repaint();
			frame.setVisible(true);
		}	
	}
	
	public class GamePanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			
			gamepanel.setLayout(null);

			if(firstStage == true) //첫번째 방
			{
				//버튼들
				closebutton1.setBounds(530, 63, 25, 25);
				closebutton1.setOpaque(false);
				closebutton1.setContentAreaFilled(false);
				closebutton1.setBorderPainted(false);
				
				itembutton1.setBounds(inventory_x, inventory_y, 40, 40);
				itembutton1.setOpaque(false);
				itembutton1.setContentAreaFilled(false);
				itembutton1.setBorderPainted(false);
				
				itembutton2.setBounds(inventory_x + 60, inventory_y, 40, 40);
				itembutton2.setOpaque(false);
				itembutton2.setContentAreaFilled(false);
				itembutton2.setBorderPainted(false);
				
				itembutton3.setBounds(inventory_x + 120, inventory_y, 40, 40);
				itembutton3.setOpaque(false);
				itembutton3.setContentAreaFilled(false);
				itembutton3.setBorderPainted(false);
				
				itembutton4.setBounds(inventory_x + 180, inventory_y, 40, 40);
				itembutton4.setOpaque(false);
				itembutton4.setContentAreaFilled(false);
				itembutton4.setBorderPainted(false);
				
				itembutton5.setBounds(inventory_x + 240, inventory_y, 40, 40);
				itembutton5.setOpaque(false);
				itembutton5.setContentAreaFilled(false);
				itembutton5.setBorderPainted(false);
				
				itembutton6.setBounds(inventory_x + 300, inventory_y, 40, 40);
				itembutton6.setOpaque(false);
				itembutton6.setContentAreaFilled(false);
				itembutton6.setBorderPainted(false);
				
				itembutton7.setBounds(inventory_x + 360, inventory_y, 40, 40);
				itembutton7.setOpaque(false);
				itembutton7.setContentAreaFilled(false);
				itembutton7.setBorderPainted(false);
				
				pagebutton_left.setBounds(87, 365, 25, 25);
				pagebutton_left.setOpaque(false);
				pagebutton_left.setContentAreaFilled(false);
				pagebutton_left.setBorderPainted(false);
				
				pagebutton_right.setBounds(528, 365, 25, 25);
				pagebutton_right.setOpaque(false);
				pagebutton_right.setContentAreaFilled(false);
				pagebutton_right.setBorderPainted(false);
				
				drawer_button_left.setBounds(188, 198, 20, 20);
				drawer_button_left.setOpaque(false);
				drawer_button_left.setContentAreaFilled(false);
				drawer_button_left.setBorderPainted(false);
				
				drawer_button_right.setBounds(434, 198, 20, 20);
				drawer_button_right.setOpaque(false);
				drawer_button_right.setContentAreaFilled(false);
				drawer_button_right.setBorderPainted(false);
				
				carpet_button.setBounds(305, 188, 104, 51);
				carpet_button.setOpaque(false);
				carpet_button.setContentAreaFilled(false);
				carpet_button.setBorderPainted(false);
				
				door_change1.setBounds(297, 250, 42, 42);
				door_change1.setOpaque(false);
				door_change1.setContentAreaFilled(false);
				door_change1.setBorderPainted(false);
				
				door_change2.setBounds(357, 150, 42, 42);
				door_change2.setOpaque(false);
				door_change2.setContentAreaFilled(false);
				door_change2.setBorderPainted(false);
				
				door_change3.setBounds(237, 150, 42, 42);
				door_change3.setOpaque(false);
				door_change3.setContentAreaFilled(false);
				door_change3.setBorderPainted(false);
				
				door_ok.setBounds(295, 180, 47, 47);
				door_ok.setOpaque(false);
				door_ok.setContentAreaFilled(false);
				door_ok.setBorderPainted(false);
				
				popup_button_0.setBounds(386, 258, 16, 16);
				popup_button_0.setOpaque(false);
				popup_button_0.setContentAreaFilled(false);
				popup_button_0.setBorderPainted(false);
				
				popup_button_1.setBounds(362, 238, 16, 16);
				popup_button_1.setOpaque(false);
				popup_button_1.setContentAreaFilled(false);
				popup_button_1.setBorderPainted(false);
				
				popup_button_2.setBounds(386, 238, 16, 16);
				popup_button_2.setOpaque(false);
				popup_button_2.setContentAreaFilled(false);
				popup_button_2.setBorderPainted(false);
				
				popup_button_3.setBounds(410, 238, 16, 16);
				popup_button_3.setOpaque(false);
				popup_button_3.setContentAreaFilled(false);
				popup_button_3.setBorderPainted(false);
				
				popup_button_4.setBounds(362, 218, 16, 16);
				popup_button_4.setOpaque(false);
				popup_button_4.setContentAreaFilled(false);
				popup_button_4.setBorderPainted(false);
				
				popup_button_5.setBounds(386, 218, 16, 16);
				popup_button_5.setOpaque(false);
				popup_button_5.setContentAreaFilled(false);
				popup_button_5.setBorderPainted(false);
				
				popup_button_6.setBounds(410, 218, 16, 16);
				popup_button_6.setOpaque(false);
				popup_button_6.setContentAreaFilled(false);
				popup_button_6.setBorderPainted(false);
				
				popup_button_7.setBounds(362, 198, 16, 16);
				popup_button_7.setOpaque(false);
				popup_button_7.setContentAreaFilled(false);
				popup_button_7.setBorderPainted(false);
				
				popup_button_8.setBounds(386, 198, 16, 16);
				popup_button_8.setOpaque(false);
				popup_button_8.setContentAreaFilled(false);
				popup_button_8.setBorderPainted(false);
				
				popup_button_9.setBounds(410, 198, 16, 16);
				popup_button_9.setOpaque(false);
				popup_button_9.setContentAreaFilled(false);
				popup_button_9.setBorderPainted(false);
				
				popup_button_ok.setBounds(362, 258, 16, 16);
				popup_button_ok.setOpaque(false);
				popup_button_ok.setContentAreaFilled(false);
				popup_button_ok.setBorderPainted(false);
				
				popup_button_x.setBounds(410, 258, 16, 16);
				popup_button_x.setOpaque(false);
				popup_button_x.setContentAreaFilled(false);
				popup_button_x.setBorderPainted(false);
				
				lullaby_button.setBounds(200, 147, 164, 136);
				lullaby_button.setOpaque(false);
				lullaby_button.setContentAreaFilled(false);
				lullaby_button.setBorderPainted(false);
				
				music_button.setBounds(332, 75, 190, 226);
				music_button.setOpaque(false);
				music_button.setContentAreaFilled(false);
				music_button.setBorderPainted(false);
				
				key_button.setBounds(298, 177, 46, 55);
				key_button.setOpaque(false);
				key_button.setContentAreaFilled(false);
				key_button.setBorderPainted(false);
				
				red_marble.setBounds(505, 185, 35, 36);
				red_marble.setOpaque(false);
				red_marble.setContentAreaFilled(false);
				red_marble.setBorderPainted(false);
				
				cushion.setBounds(426, 116, 125, 103);
				cushion.setOpaque(false);
				cushion.setContentAreaFilled(false);
				cushion.setBorderPainted(false);
				
				bookshelf_button_left.setBounds(141, 116, 182, 209);
				bookshelf_button_left.setOpaque(false);
				bookshelf_button_left.setContentAreaFilled(false);
				bookshelf_button_left.setBorderPainted(false);
				
				bookshelf_button_right.setBounds(499, 155, 18, 19);
				bookshelf_button_right.setOpaque(false);
				bookshelf_button_right.setContentAreaFilled(false);
				bookshelf_button_right.setBorderPainted(false);
				
				spoon.setBounds(316, 164, 12, 36);
				spoon.setOpaque(false);
				spoon.setContentAreaFilled(false);
				spoon.setBorderPainted(false);
				
				cabinet_hint.setBounds(280, 222, 21, 74);
				cabinet_hint.setOpaque(false);
				cabinet_hint.setContentAreaFilled(false);
				cabinet_hint.setBorderPainted(false);
				
				red_light.setBounds(206, 188, 58, 56);
				red_light.setOpaque(false);
				red_light.setContentAreaFilled(false);
				red_light.setBorderPainted(false);
				
				door_recipe.setBounds(237, 139, 146, 104);
				door_recipe.setOpaque(false);
				door_recipe.setContentAreaFilled(false);
				door_recipe.setBorderPainted(false);
				
				dust_button.setBounds(309, 222, 53, 53);
				dust_button.setOpaque(false);
				dust_button.setContentAreaFilled(false);
				dust_button.setBorderPainted(false);
				
				door_hint.setBounds(338, 175, 27, 18);
				door_hint.setOpaque(false);
				door_hint.setContentAreaFilled(false);
				door_hint.setBorderPainted(false);
				
				gori.setBounds(305, 239, 31, 14);
				gori.setOpaque(false);
				gori.setContentAreaFilled(false);
				gori.setBorderPainted(false);
				
				yellow_marble.setBounds(289, 213, 57, 29);
				yellow_marble.setOpaque(false);
				yellow_marble.setContentAreaFilled(false);
				yellow_marble.setBorderPainted(false);
				
				//항아리에 재료를 다 넣었을 때
				if(drug_isget == false && kettle_sand == true && kettle_lullaby == true && kettle_dust == true)
				{
					inventory_list.add(drug_icon);
					item_information.add(drug_detail);
					drug_isget = true;
				}
				
				//배경 이미지, 오브젝트둘 출력
				g.drawImage(stage1.getImage(), background_x, background_y, MAP_WIDTH, MAP_HEIGHT, this);
				if(kettle_sand == true && kettle_lullaby == true && kettle_dust == true)
				{
					kettle_soup.drawObject(g2d);
				}
				else
				{
					kettle.drawObject(g2d);
				}
				bookshelf.drawObject(g2d);
				drawer.drawObject(g2d);
				sofa.drawObject(g2d);
				box.drawObject(g2d);
				square_desk.drawObject(g2d);
				marimba.drawObject(g2d);
				if(black_isget == true)
				{
					marble_black.drawObject(g2d);
				}
				if(yellow_isget == true)
				{
					marble_yellow.drawObject(g2d);
				}
				if(red_isget == true)
				{
					marble_red.drawObject(g2d);
				}
				
				if(sheet_isget == false)
				{
					round_desk_sheet.drawObject(g2d);
				}
				else
				{
					round_desk.drawObject(g2d);
				}
				
				if(broom_isclear == false)
				{
					broom_dust.drawObject(g2d);
				}
				else
				{
					broom.drawObject(g2d);
				}
				
				if(glass_isget == false)
				{
					if(cabinet_isopen == false)
					{
						cabinet_close_glass.drawObject(g2d);
					}
					else
					{
						cabinet_open_glass.drawObject(g2d);
					}
				}
				else
				{
					if(cabinet_isopen == false)
					{
						cabinet_close.drawObject(g2d);
					}
					else
					{
						cabinet_open.drawObject(g2d);
					}
				}
				
				if(magic_paper1.isget == false)
				{
					magic_paper1.drawObject(g2d);
				}
				
				if(directionback == true)
				{
					g.drawImage(generalChar_front.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				else if(directionright == true)
				{
					g.drawImage(generalChar_right.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				else if(directionleft == true)
				{
					g.drawImage(generalChar_left.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				else if(directionfront == true)
				{
					g.drawImage(generalChar_back.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				
				if(kettle.ismessage == true)//항아리 팝업창
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(kettle_sand == true && kettle_lullaby == true && kettle_dust == true)
					{
						g.drawImage(popup_kettle_soup.getImage(), 0, 0, 640, 480, this);
					}
					else
					{
						g.drawImage(popup_kettle.getImage(), 0, 0, 640, 480, this);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1) //아이켐 목록 출력
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								//아이템 목록에서 특정한 아이템을 눌렀을 때
								if(kettle_sand == false && inventory_list.get(0).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item1_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(0).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item1_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(0).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item1_info = false;
								}
								else
								{
									g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
								}
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								if(kettle_sand == false && inventory_list.get(1).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item2_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(1).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item2_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(1).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item2_info = false;
								}
								else
								{
									g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
								}
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								if(kettle_sand == false && inventory_list.get(2).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item3_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(2).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item3_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(2).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item3_info = false;
								}
								else
								{
									g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
								}
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								if(kettle_sand == false && inventory_list.get(3).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item4_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(3).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item4_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(3).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item4_info = false;
								}
								else
								{
									g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								if(kettle_sand == false && inventory_list.get(4).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item5_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(4).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item5_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(4).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item5_info = false;
								}
								else
								{
									g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								if(kettle_sand == false && inventory_list.get(5).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item6_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(5).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item6_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(5).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item6_info = false;
								}
								else
								{
									g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								if(kettle_sand == false && inventory_list.get(6).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item7_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(6).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item7_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(6).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item7_info = false;
								}
								else
								{
									g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								if(kettle_sand == false && inventory_list.get(7).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item1_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(7).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item1_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(7).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item1_info = false;
								}
								else
								{
									g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								if(kettle_sand == false && inventory_list.get(8).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item2_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(8).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item2_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(8).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item2_info = false;
								}
								else
								{
									g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
								}
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								if(kettle_sand == false && inventory_list.get(9).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item3_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(9).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item3_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(9).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item3_info = false;
								}
								else
								{
									g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								if(kettle_sand == false && inventory_list.get(10).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item4_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(10).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item4_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(10).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item4_info = false;
								}
								else
								{
									g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item5_info == true)
						{
							
							if(inventory_list.size() > 11)
							{
								if(kettle_sand == false && inventory_list.get(11).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item5_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(11).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item5_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(11).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item5_info = false;
								}
								else
								{
									g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								if(kettle_sand == false && inventory_list.get(12).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item6_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(12).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item6_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(12).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item6_info = false;
								}
								else
								{
									g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								if(kettle_sand == false && inventory_list.get(13).equals(spoon_sand_icon))
								{
									for(int i = inventory_list.indexOf(spoon_sand_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(spoon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_sand = true;
									item7_info = false;
								}
								else if(kettle_lullaby == false && inventory_list.get(13).equals(lullaby_icon))
								{
									for(int i = inventory_list.indexOf(lullaby_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(lullaby_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_lullaby = true;
									item7_info = false;
								}
								else if(kettle_dust == false && inventory_list.get(13).equals(glass_dust_icon))
								{
									for(int i = inventory_list.indexOf(glass_dust_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(glass_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									kettle_dust = true;
									item7_info = false;
								}
								else
								{
									g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
					}
				}
				else if(square_desk.ismessage == true) //책상 팝업
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(popup_square_book.getImage(), 0, 0, 640, 480, this);
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1) //인벤토리 목록
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(box.ismessage == true) //박스 팝업
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					
					if(box_isopen == true)
					{
						g.drawImage(popup_box_open.getImage(), 0, 0, 640, 480, this);
						gamepanel.remove(gori);
						if(yellow_marble_isget == false)
						{
							gamepanel.add(yellow_marble);
						}
						else
						{
							gamepanel.remove(yellow_marble);
						}
					}
					else
					{
						g.drawImage(popup_box_close.getImage(), 0, 0, 640, 480, this);
						gamepanel.add(gori);
					}
					
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(drawer.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(drawer_left == false && drawer_right == false)
					{
						g.drawImage(popup_drawer.getImage(), 0, 0, 640, 480, this);
						drawer_button_left.setBounds(188, 198, 20, 20);
						drawer_button_right.setBounds(434, 198, 20, 20);
						gamepanel.add(drawer_button_left);
						gamepanel.add(drawer_button_right);
						gamepanel.remove(door_recipe);
						gamepanel.remove(key_button);
					}
					else if(drawer_left == true)
					{
						if(key_isget == false)
						{
							gamepanel.add(key_button);
						}
						else
						{
							gamepanel.remove(key_button);
						}
						g.drawImage(popup_drawer_left.getImage(), 0, 0, 640, 480, this);
						drawer_button_left.setBounds(258, 308, 124, 31);
						gamepanel.remove(drawer_button_right);
						gamepanel.remove(door_recipe);
					}
					else if(drawer_right == true)
					{
						if(drawer_right_isopen == false)
						{
							g.drawImage(popup_drawer_right_close.getImage(), 0, 0, 640, 480, this);
							popup_button_1.setBounds(402, 166, 37, 45);
							gamepanel.add(popup_button_1);
							popup_button_2.setBounds(453, 166, 37, 45);
							gamepanel.add(popup_button_2);
							popup_button_3.setBounds(502, 166, 37, 45);
							gamepanel.add(popup_button_3);
							popup_button_4.setBounds(402, 225, 37, 45);
							gamepanel.add(popup_button_4);
							popup_button_5.setBounds(453, 225, 37, 45);
							gamepanel.add(popup_button_5);
							popup_button_6.setBounds(502, 225, 37, 45);
							gamepanel.add(popup_button_6);
							drawer_button_right.setBounds(258, 196, 124, 47);
							if(stack.size() == 6)
							{
								for(int i = 5; i >= 0; i--)
								{
									temp = stack.pop();
									if(drawer_correct[i] != temp)
									{
										stack.push(temp);
									}
									else
									{
										continue;
									}
								}
								if(stack.isEmpty() == true)
								{
									drawer_right_isopen = true;
									stack.init();
								}
								else
								{
									stack.init();
								}
							}
							gamepanel.remove(drawer_button_left);
							System.out.printf("Stack size -> %d\n", stack.size());
						}
						else
						{
							g.drawImage(popup_drawer_right.getImage(), 0, 0, 640, 480, this);
							drawer_button_right.setBounds(258, 308, 124, 31);
							if(recipe_isget == false)
							{
								gamepanel.add(door_recipe);
							}
							else
							{
								gamepanel.remove(door_recipe);
							}
							gamepanel.remove(drawer_button_left);
							gamepanel.remove(popup_button_1);
							gamepanel.remove(popup_button_2);
							gamepanel.remove(popup_button_3);
							gamepanel.remove(popup_button_4);
							gamepanel.remove(popup_button_5);
							gamepanel.remove(popup_button_6);
						}
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(sofa.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(popup_sofa.getImage(), 0, 0, 640, 480, this);
					if(cushion_up == false)
					{
						cushion.setBounds(426, 116, 125, 103);
						gamepanel.add(cushion);
					}
					else
					{
						cushion.setBounds(326, 116, 125, 103);
						gamepanel.add(cushion);
					}
					
					if(red_marble_isget == false)
					{
						gamepanel.add(red_marble);
					}
					else
					{
						gamepanel.remove(red_marble);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(round_desk.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(popup_magic_book.getImage(), 0, 0, 640, 480, this);
					if(sheet_isget == false)
					{
						gamepanel.add(music_button);
					}
					else
					{
						gamepanel.remove(music_button);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(marimba.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(popup_marimba.getImage(), 0, 0, 640, 480, this);
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(cabinet_close_glass.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(cabinet_isopen == false)
					{
						g.drawImage(popup_cabinet_close.getImage(), 0, 0, 640, 480, this);
						gamepanel.add(popup_button_0);
						gamepanel.add(popup_button_1);
						gamepanel.add(popup_button_2);
						gamepanel.add(popup_button_3);
						gamepanel.add(popup_button_4);
						gamepanel.add(popup_button_5);
						gamepanel.add(popup_button_6);
						gamepanel.add(popup_button_7);
						gamepanel.add(popup_button_8);
						gamepanel.add(popup_button_9);
						gamepanel.add(popup_button_ok);
						gamepanel.add(popup_button_x);
						System.out.printf("Stack size -> %d\n", stack.size());
						if(password_fail == true)
						{
							g.drawImage(popup_led_red.getImage(), 424, 183, 10, 10, this);
							if(times - inter_time == 40)
							{
								password_fail = false;
							}
						}
					}
					else
					{
						g.drawImage(popup_cabinet_open.getImage(), 0, 0, 640, 480, this);
						gamepanel.remove(popup_button_0);
						gamepanel.remove(popup_button_1);
						gamepanel.remove(popup_button_2);
						gamepanel.remove(popup_button_3);
						gamepanel.remove(popup_button_4);
						gamepanel.remove(popup_button_5);
						gamepanel.remove(popup_button_6);
						gamepanel.remove(popup_button_7);
						gamepanel.remove(popup_button_8);
						gamepanel.remove(popup_button_9);
						gamepanel.remove(popup_button_ok);
						gamepanel.remove(popup_button_x);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(safe_ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(safe_isopen == false)
					{
						g.drawImage(popup_safe_close.getImage(), 0, 0, 640, 480, this);
						popup_button_0.setBounds(340, 256, 20, 20);
						gamepanel.add(popup_button_0);
						popup_button_1.setBounds(293, 224, 20, 20);
						gamepanel.add(popup_button_1);
						popup_button_2.setBounds(340, 224, 20, 20);
						gamepanel.add(popup_button_2);
						popup_button_3.setBounds(387, 224, 20, 20);
						gamepanel.add(popup_button_3);
						popup_button_4.setBounds(293, 191, 20, 20);
						gamepanel.add(popup_button_4);
						popup_button_5.setBounds(340, 191, 20, 20);
						gamepanel.add(popup_button_5);
						popup_button_6.setBounds(387, 191, 20, 20);
						gamepanel.add(popup_button_6);
						popup_button_7.setBounds(293, 158, 20, 20);
						gamepanel.add(popup_button_7);
						popup_button_8.setBounds(340, 158, 20, 20);
						gamepanel.add(popup_button_8);
						popup_button_9.setBounds(387, 158, 20, 20);
						gamepanel.add(popup_button_9);
						popup_button_ok.setBounds(293, 256, 20, 20);
						gamepanel.add(popup_button_ok);
						popup_button_x.setBounds(387, 256, 20, 20);
						gamepanel.add(popup_button_x);
						System.out.printf("Stack size -> %d\n", stack.size());
					}
					else
					{
						g.drawImage(popup_safe_open.getImage(), 0, 0, 640, 480, this);
						gamepanel.remove(popup_button_0);
						gamepanel.remove(popup_button_1);
						gamepanel.remove(popup_button_2);
						gamepanel.remove(popup_button_3);
						gamepanel.remove(popup_button_4);
						gamepanel.remove(popup_button_5);
						gamepanel.remove(popup_button_6);
						gamepanel.remove(popup_button_7);
						gamepanel.remove(popup_button_8);
						gamepanel.remove(popup_button_9);
						gamepanel.remove(popup_button_ok);
						gamepanel.remove(popup_button_x);
						if(lullaby_isget == false)
						{
							gamepanel.add(lullaby_button);
						}
						else
						{
							gamepanel.remove(lullaby_button);
						}
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(door_ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(yellow_isget == true && red_isget == true && black_isget == true)
					{
						gamepanel.add(door_ok);
						gamepanel.add(door_change1);
						gamepanel.add(door_change2);
						gamepanel.add(door_change3);
					}
					
					if(door_black == false && door_desert == false)
					{
						g.drawImage(popup_door_basic.getImage(), 0, 0, 640, 480, this);
					}
					else if(door_desert == true)
					{
						g.drawImage(popup_door_desert.getImage(), 0, 0, 640, 480, this);
						gamepanel.remove(door_ok);
						gamepanel.remove(door_change1);
						gamepanel.remove(door_change2);
						gamepanel.remove(door_change3);
					}
					else if(door_black == true)
					{
						g.drawImage(popup_door_black.getImage(), 0, 0, 640, 480, this);
						gamepanel.remove(door_ok);
						gamepanel.remove(door_change1);
						gamepanel.remove(door_change2);
						gamepanel.remove(door_change3);
					}
					
					if(yellow_isget == true)
					{
						g.drawImage(door_marble.get(0).getImage(), 210, 205, 79, 79, this);
					}
					if(red_isget == true)
					{
						g.drawImage(door_marble.get(1).getImage(), 355, 205, 79, 79, this);
					}
					if(black_isget == true)
					{
						g.drawImage(door_marble.get(2).getImage(), 278, 80, 79, 79, this);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								if(inventory_list.get(0).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item1_info = false;
								}
								else if(inventory_list.get(0).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item1_info = false;
								}
								else if(inventory_list.get(0).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item1_info = false;
								}
								else if(door_desert == true && inventory_list.get(0).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item1_info = false;
								}
								else if(door_black == true && inventory_list.get(0).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
								}
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								if(inventory_list.get(1).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item2_info = false;
								}
								else if(inventory_list.get(1).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item2_info = false;
								}
								else if(inventory_list.get(1).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item2_info = false;
								}
								else if(door_desert == true && inventory_list.get(1).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item2_info = false;
								}
								else if(door_black == true && inventory_list.get(1).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
								}
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								if(inventory_list.get(2).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item3_info = false;
								}
								else if(inventory_list.get(2).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item3_info = false;
								}
								else if(inventory_list.get(2).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item3_info = false;
								}
								else if(door_desert == true && inventory_list.get(2).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item3_info = false;
								}
								else if(door_black == true && inventory_list.get(2).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
								}
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								if(inventory_list.get(3).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item4_info = false;
								}
								else if(inventory_list.get(3).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item4_info = false;
								}
								else if(inventory_list.get(3).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item4_info = false;
								}
								else if(door_desert == true && inventory_list.get(3).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item4_info = false;
								}
								else if(door_black == true && inventory_list.get(3).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								if(inventory_list.get(4).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item5_info = false;
								}
								else if(inventory_list.get(4).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item5_info = false;
								}
								else if(inventory_list.get(4).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item5_info = false;
								}
								else if(door_desert == true && inventory_list.get(4).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item5_info = false;
								}
								else if(door_black == true && inventory_list.get(4).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								if(inventory_list.get(5).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item6_info = false;
								}
								else if(inventory_list.get(5).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item6_info = false;
								}
								else if(inventory_list.get(5).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item6_info = false;
								}
								else if(door_desert == true && inventory_list.get(5).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item6_info = false;
								}
								else if(door_black == true && inventory_list.get(5).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								if(inventory_list.get(6).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item7_info = false;
								}
								else if(inventory_list.get(6).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item7_info = false;
								}
								else if(inventory_list.get(6).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item7_info = false;
								}
								else if(door_desert == true && inventory_list.get(6).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item7_info = false;
								}
								else if(door_black == true && inventory_list.get(6).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								if(inventory_list.get(7).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item1_info = false;
								}
								else if(inventory_list.get(7).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item1_info = false;
								}
								else if(inventory_list.get(7).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item1_info = false;
								}
								else if(door_desert == true && inventory_list.get(7).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item1_info = false;
								}
								else if(door_black == true && inventory_list.get(7).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								if(inventory_list.get(8).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item2_info = false;
								}
								else if(inventory_list.get(8).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item2_info = false;
								}
								else if(inventory_list.get(8).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item2_info = false;
								}
								else if(door_desert == true && inventory_list.get(8).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item2_info = false;
								}
								else if(door_black == true && inventory_list.get(8).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
								}
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								if(inventory_list.get(9).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item3_info = false;
								}
								else if(inventory_list.get(9).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item3_info = false;
								}
								else if(inventory_list.get(9).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item3_info = false;
								}
								else if(door_desert == true && inventory_list.get(9).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item3_info = false;
								}
								else if(door_black == true && inventory_list.get(9).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								if(inventory_list.get(10).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item4_info = false;
								}
								else if(inventory_list.get(10).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item4_info = false;
								}
								else if(inventory_list.get(10).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item4_info = false;
								}
								else if(door_desert == true && inventory_list.get(10).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item4_info = false;
								}
								else if(door_black == true && inventory_list.get(10).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								if(inventory_list.get(11).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item5_info = false;
								}
								else if(inventory_list.get(11).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item5_info = false;
								}
								else if(inventory_list.get(11).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item5_info = false;
								}
								else if(door_desert == true && inventory_list.get(11).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item5_info = false;
								}
								else if(door_black == true && inventory_list.get(11).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								if(inventory_list.get(12).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item6_info = false;
								}
								else if(inventory_list.get(12).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item6_info = false;
								}
								else if(inventory_list.get(12).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item6_info = false;
								}
								else if(door_desert == true && inventory_list.get(12).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item6_info = false;
								}
								else if(door_black == true && inventory_list.get(12).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								if(inventory_list.get(13).equals(marble_red_icon))
								{
									for(int i = inventory_list.indexOf(marble_red_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									red_isget = true;
									item7_info = false;
								}
								else if(inventory_list.get(13).equals(marble_yellow_icon))
								{
									for(int i = inventory_list.indexOf(marble_yellow_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_yellow_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									yellow_isget = true;
									item7_info = false;
								}
								else if(inventory_list.get(13).equals(marble_black_icon))
								{
									for(int i = inventory_list.indexOf(marble_black_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(marble_black_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									black_isget = true;
									item7_info = false;
								}
								else if(door_desert == true && inventory_list.get(13).equals(spoon_icon))
								{
									inventory_list.set(inventory_list.indexOf(spoon_icon), spoon_sand_icon);
									item7_info = false;
								}
								else if(door_black == true && inventory_list.get(13).equals(drug_icon))
								{
									firstStage = false;
									secondStage = true;
									char_init = true;
									lp.setLayer(gamepanel2, 4);
									gamepanel2.setFocusable(true);
									gamepanel2.requestFocus();
								}
								else
								{
									g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
					}
				}
				else if(bookshelf.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					
					if(bookshelf_left == false && bookshelf_right == false)
					{
						g.drawImage(popup_bookshelf.getImage(), 0, 0, 640, 480, this);
						gamepanel.add(bookshelf_button_left);
						bookshelf_button_right.setBounds(499, 155, 18, 19);
						gamepanel.add(bookshelf_button_right);
						gamepanel.remove(spoon);
						gamepanel.remove(cabinet_hint);
						gamepanel.remove(red_light);
						gamepanel.remove(door_hint);
					}
					else if(bookshelf_right == true)
					{
						g.drawImage(popup_bookshelf_right.getImage(), 0, 0, 640, 480, this);
						if(spoon_isget == false)
						{
							gamepanel.add(spoon);
						}
						else
						{
							gamepanel.remove(spoon);
						}
						
						if(door_hint_isget == false)
						{
							gamepanel.add(door_hint);
						}
						else
						{
							gamepanel.remove(door_hint);
						}
						bookshelf_button_right.setBounds(310, 231, 20, 20);
						gamepanel.remove(bookshelf_button_left);
						gamepanel.remove(cabinet_hint);
						gamepanel.remove(red_light);
					}
					else if(bookshelf_left == true)
					{
						g.drawImage(popup_bookshelf.getImage(), 0, 0, 640, 480, this);
						if(key_isget == true)
						{
							gamepanel.remove(bookshelf_button_left);
							gamepanel.remove(door_hint);
							if(cabinet_hint_isget == false)
							{
								gamepanel.add(cabinet_hint);
							}
							else
							{
								gamepanel.remove(cabinet_hint);
							}
							
							if(redlight_isget == false)
							{
								gamepanel.add(red_light);
							}
							else
							{
								gamepanel.remove(red_light);
							}
						}
						gamepanel.remove(spoon);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(broom_dust.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(broom_isclear == false)
					{
						g.drawImage(popup_broom.getImage(), 0, 0, 640, 480, this);
						gamepanel.add(dust_button);
					}
					else
					{
						gamepanel.remove(dust_button);
						g.drawImage(popup_broom_clear.getImage(), 0, 0, 640, 480, this);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
							}					
						}
					}
				}
				else if(magic_paper1.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(popup_carpet.getImage(), 0, 0, 640, 480, this);
					if(magic_paper1.isget == false)
					{
						gamepanel.add(carpet_button);
					}
					else
					{
						gamepanel.remove(carpet_button);
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(closebutton1);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(inventory == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(inven.getImage(), 0, 0, 640, 480, this);
					
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel.add(itembutton1);
					gamepanel.add(itembutton2);
					gamepanel.add(itembutton3);
					gamepanel.add(itembutton4);
					gamepanel.add(itembutton5);
					gamepanel.add(itembutton6);
					gamepanel.add(itembutton7);
					gamepanel.add(pagebutton_left);
					gamepanel.add(pagebutton_right);
					
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
					
					gamepanel.add(closebutton1);
				}
				else
				{
					gamepanel.remove(closebutton1);
					gamepanel.remove(itembutton1);
					gamepanel.remove(itembutton2);
					gamepanel.remove(itembutton3);
					gamepanel.remove(itembutton4);
					gamepanel.remove(itembutton5);
					gamepanel.remove(itembutton6);
					gamepanel.remove(itembutton7);
					gamepanel.remove(pagebutton_left);
					gamepanel.remove(pagebutton_right);
					gamepanel.remove(drawer_button_left);
					gamepanel.remove(drawer_button_right);
					gamepanel.remove(carpet_button);
					gamepanel.remove(door_change1);
					gamepanel.remove(door_change2);
					gamepanel.remove(door_change3);
					gamepanel.remove(door_ok);
					gamepanel.remove(popup_button_0);
					gamepanel.remove(popup_button_1);
					gamepanel.remove(popup_button_2);
					gamepanel.remove(popup_button_3);
					gamepanel.remove(popup_button_4);
					gamepanel.remove(popup_button_5);
					gamepanel.remove(popup_button_6);
					gamepanel.remove(popup_button_7);
					gamepanel.remove(popup_button_8);
					gamepanel.remove(popup_button_9);
					gamepanel.remove(popup_button_ok);
					gamepanel.remove(popup_button_x);
					gamepanel.remove(lullaby_button);
					gamepanel.remove(music_button);
					gamepanel.remove(key_button);
					gamepanel.remove(cushion);
					gamepanel.remove(red_marble);
					gamepanel.remove(bookshelf_button_left);
					gamepanel.remove(bookshelf_button_right);
					gamepanel.remove(spoon);
					gamepanel.remove(cabinet_hint);
					gamepanel.remove(red_light);
					gamepanel.remove(door_recipe);
					gamepanel.remove(dust_button);
					gamepanel.remove(door_hint);
					gamepanel.remove(gori);
					gamepanel.remove(yellow_marble);
				}
			}
			goChar.start();
			goTime.start();
			
			gamepanel.setFocusable(true);
			gamepanel.requestFocus();
			frame.repaint();
			frame.setVisible(true);
		}
	}
	
	public class GamePanel2 extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
			
			gamepanel2.setLayout(null);
			
			if(redlight_isget == false && bluelight_isget == false && greenlight_isget == false && machine.ismessage == false)
			{
				if(ending_count == 0)
				{
					gamepanel2.remove(closebutton1);
					gamepanel2.remove(itembutton1);
					gamepanel2.remove(itembutton2);
					gamepanel2.remove(itembutton3);
					gamepanel2.remove(itembutton4);
					gamepanel2.remove(itembutton5);
					gamepanel2.remove(itembutton6);
					gamepanel2.remove(itembutton7);
					gamepanel2.remove(pagebutton_left);
					gamepanel2.remove(pagebutton_right);
					gamepanel2.remove(popup_button_0);
					gamepanel2.remove(popup_button_1);
					gamepanel2.remove(popup_button_2);
					gamepanel2.remove(popup_button_3);
					gamepanel2.remove(popup_button_4);
					gamepanel2.remove(popup_button_5);
					gamepanel2.remove(popup_button_6);
					gamepanel2.remove(popup_button_7);
					gamepanel2.remove(popup_button_8);
					gamepanel2.remove(popup_button_9);
					gamepanel2.remove(popup_button_ok);
					gamepanel2.remove(popup_button_x);
					gamepanel2.remove(popup_button_10);
					gamepanel2.remove(popup_button_11);
					gamepanel2.remove(blue_light);
					gamepanel2.remove(green_light);
					gamepanel2.remove(sun);
					gamepanel2.remove(machine_red_button);
					gamepanel2.remove(machine_green_button);
					gamepanel2.remove(machine_blue_button);
				}
				
				if(ending_count <= 6200)
				{
					g.drawImage(ending_animation1.getImage(), 0, -30, 640, 480, this);
				}
				else if(ending_count > 6200 && ending_count <= 41500)
				{
					g.drawImage(ending_animation2.getImage(), 0, -30, 640, 480, this);
				}
				else if(ending_count > 41500 && ending_count <= 52500)
				{
					g.drawImage(ending_animation3.getImage(), 0, -30, 640, 480, this);
				}
				else if(ending_count > 52501)
				{
					g.drawImage(ending_animation4.getImage(), 0, -30, 640, 480, this);
				}
				
				if(ending_count <= 52001)
				{
					ending_count++;
				}
			}
			else if(secondStage == true)
			{
				gamepanel.remove(closebutton1);
				gamepanel.remove(itembutton1);
				gamepanel.remove(itembutton2);
				gamepanel.remove(itembutton3);
				gamepanel.remove(itembutton4);
				gamepanel.remove(itembutton5);
				gamepanel.remove(itembutton6);
				gamepanel.remove(itembutton7);
				gamepanel.remove(pagebutton_left);
				gamepanel.remove(pagebutton_right);
				gamepanel.remove(drawer_button_left);
				gamepanel.remove(drawer_button_right);
				gamepanel.remove(carpet_button);
				gamepanel.remove(door_change1);
				gamepanel.remove(door_change2);
				gamepanel.remove(door_change3);
				gamepanel.remove(door_ok);
				gamepanel.remove(popup_button_0);
				gamepanel.remove(popup_button_1);
				gamepanel.remove(popup_button_2);
				gamepanel.remove(popup_button_3);
				gamepanel.remove(popup_button_4);
				gamepanel.remove(popup_button_5);
				gamepanel.remove(popup_button_6);
				gamepanel.remove(popup_button_7);
				gamepanel.remove(popup_button_8);
				gamepanel.remove(popup_button_9);
				gamepanel.remove(popup_button_ok);
				gamepanel.remove(popup_button_x);
				gamepanel.remove(lullaby_button);
				gamepanel.remove(music_button);
				gamepanel.remove(key_button);
				gamepanel.remove(cushion);
				gamepanel.remove(red_marble);
				gamepanel.remove(bookshelf_button_left);
				gamepanel.remove(bookshelf_button_right);
				gamepanel.remove(spoon);
				gamepanel.remove(cabinet_hint);
				gamepanel.remove(red_light);
				gamepanel.remove(dust_button);
				gamepanel.remove(door_recipe);
				gamepanel.remove(door_hint);
				gamepanel.remove(gori);
				gamepanel.remove(yellow_marble);
				
				closebutton1.setBounds(530, 63, 25, 25);
				closebutton1.setOpaque(false);
				closebutton1.setContentAreaFilled(false);
				closebutton1.setBorderPainted(false);
				
				itembutton1.setBounds(inventory_x, inventory_y, 40, 40);
				itembutton1.setOpaque(false);
				itembutton1.setContentAreaFilled(false);
				itembutton1.setBorderPainted(false);
				
				itembutton2.setBounds(inventory_x + 60, inventory_y, 40, 40);
				itembutton2.setOpaque(false);
				itembutton2.setContentAreaFilled(false);
				itembutton2.setBorderPainted(false);
				
				itembutton3.setBounds(inventory_x + 120, inventory_y, 40, 40);
				itembutton3.setOpaque(false);
				itembutton3.setContentAreaFilled(false);
				itembutton3.setBorderPainted(false);
				
				itembutton4.setBounds(inventory_x + 180, inventory_y, 40, 40);
				itembutton4.setOpaque(false);
				itembutton4.setContentAreaFilled(false);
				itembutton4.setBorderPainted(false);
				
				itembutton5.setBounds(inventory_x + 240, inventory_y, 40, 40);
				itembutton5.setOpaque(false);
				itembutton5.setContentAreaFilled(false);
				itembutton5.setBorderPainted(false);
				
				itembutton6.setBounds(inventory_x + 300, inventory_y, 40, 40);
				itembutton6.setOpaque(false);
				itembutton6.setContentAreaFilled(false);
				itembutton6.setBorderPainted(false);
				
				itembutton7.setBounds(inventory_x + 360, inventory_y, 40, 40);
				itembutton7.setOpaque(false);
				itembutton7.setContentAreaFilled(false);
				itembutton7.setBorderPainted(false);
				
				pagebutton_left.setBounds(87, 365, 25, 25);
				pagebutton_left.setOpaque(false);
				pagebutton_left.setContentAreaFilled(false);
				pagebutton_left.setBorderPainted(false);
				
				pagebutton_right.setBounds(528, 365, 25, 25);
				pagebutton_right.setOpaque(false);
				pagebutton_right.setContentAreaFilled(false);
				pagebutton_right.setBorderPainted(false);
				
				popup_button_0.setBounds(386, 258, 16, 16);
				popup_button_0.setOpaque(false);
				popup_button_0.setContentAreaFilled(false);
				popup_button_0.setBorderPainted(false);
				
				popup_button_1.setBounds(362, 238, 16, 16);
				popup_button_1.setOpaque(false);
				popup_button_1.setContentAreaFilled(false);
				popup_button_1.setBorderPainted(false);
				
				popup_button_2.setBounds(386, 238, 16, 16);
				popup_button_2.setOpaque(false);
				popup_button_2.setContentAreaFilled(false);
				popup_button_2.setBorderPainted(false);
				
				popup_button_3.setBounds(410, 238, 16, 16);
				popup_button_3.setOpaque(false);
				popup_button_3.setContentAreaFilled(false);
				popup_button_3.setBorderPainted(false);
				
				popup_button_4.setBounds(362, 218, 16, 16);
				popup_button_4.setOpaque(false);
				popup_button_4.setContentAreaFilled(false);
				popup_button_4.setBorderPainted(false);
				
				popup_button_5.setBounds(386, 218, 16, 16);
				popup_button_5.setOpaque(false);
				popup_button_5.setContentAreaFilled(false);
				popup_button_5.setBorderPainted(false);
				
				popup_button_6.setBounds(410, 218, 16, 16);
				popup_button_6.setOpaque(false);
				popup_button_6.setContentAreaFilled(false);
				popup_button_6.setBorderPainted(false);
				
				popup_button_7.setBounds(362, 198, 16, 16);
				popup_button_7.setOpaque(false);
				popup_button_7.setContentAreaFilled(false);
				popup_button_7.setBorderPainted(false);
				
				popup_button_8.setBounds(386, 198, 16, 16);
				popup_button_8.setOpaque(false);
				popup_button_8.setContentAreaFilled(false);
				popup_button_8.setBorderPainted(false);
				
				popup_button_9.setBounds(410, 198, 16, 16);
				popup_button_9.setOpaque(false);
				popup_button_9.setContentAreaFilled(false);
				popup_button_9.setBorderPainted(false);
				
				popup_button_ok.setBounds(362, 258, 16, 16);
				popup_button_ok.setOpaque(false);
				popup_button_ok.setContentAreaFilled(false);
				popup_button_ok.setBorderPainted(false);
				
				popup_button_x.setBounds(410, 258, 16, 16);
				popup_button_x.setOpaque(false);
				popup_button_x.setContentAreaFilled(false);
				popup_button_x.setBorderPainted(false);
				
				popup_button_10.setBounds(278, 305, 23, 24);
				popup_button_10.setOpaque(false);
				popup_button_10.setContentAreaFilled(false);
				popup_button_10.setBorderPainted(false);
				
				popup_button_11.setBounds(339, 305, 23, 24);
				popup_button_11.setOpaque(false);
				popup_button_11.setContentAreaFilled(false);
				popup_button_11.setBorderPainted(false);
				
				blue_light.setBounds(278, 199, 93, 97);
				blue_light.setOpaque(false);
				blue_light.setContentAreaFilled(false);
				blue_light.setBorderPainted(false);
				
				green_light.setBounds(272, 153, 110, 108);
				green_light.setOpaque(false);
				green_light.setContentAreaFilled(false);
				green_light.setBorderPainted(false);
				
				sun.setBounds(227, 111, 186, 186);
				sun.setOpaque(false);
				sun.setContentAreaFilled(false);
				sun.setBorderPainted(false);
				
				moon.setBounds(280, 204, 93, 93);
				moon.setOpaque(false);
				moon.setContentAreaFilled(false);
				moon.setBorderPainted(false);
				
				machine_red_button.setBounds(225, 188, 54, 54);
				machine_red_button.setOpaque(false);
				machine_red_button.setContentAreaFilled(false);
				machine_red_button.setBorderPainted(false);
				
				machine_blue_button.setBounds(361, 188, 54, 54);
				machine_blue_button.setOpaque(false);
				machine_blue_button.setContentAreaFilled(false);
				machine_blue_button.setBorderPainted(false);
				
				machine_green_button.setBounds(293, 188, 54, 54);
				machine_green_button.setOpaque(false);
				machine_green_button.setContentAreaFilled(false);
				machine_green_button.setBorderPainted(false);
				
				bag_button_1.setBounds(269, 183, 7, 10);
				bag_button_1.setOpaque(false);
				bag_button_1.setContentAreaFilled(false);
				bag_button_1.setBorderPainted(false);
				
				bag_button_2.setBounds(282, 183, 7, 10);
				bag_button_2.setOpaque(false);
				bag_button_2.setContentAreaFilled(false);
				bag_button_2.setBorderPainted(false);
				
				bag_button_3.setBounds(295, 183, 7, 10);
				bag_button_3.setOpaque(false);
				bag_button_3.setContentAreaFilled(false);
				bag_button_3.setBorderPainted(false);
				
				bag_button_4.setBounds(309, 183, 7, 10);
				bag_button_4.setOpaque(false);
				bag_button_4.setContentAreaFilled(false);
				bag_button_4.setBorderPainted(false);
				
				bag_button_5.setBounds(324, 183, 7, 10);
				bag_button_5.setOpaque(false);
				bag_button_5.setContentAreaFilled(false);
				bag_button_5.setBorderPainted(false);
				
				bag_button_6.setBounds(338, 183, 7, 10);
				bag_button_6.setOpaque(false);
				bag_button_6.setContentAreaFilled(false);
				bag_button_6.setBorderPainted(false);
				
				bag_button_7.setBounds(351, 183, 7, 10);
				bag_button_7.setOpaque(false);
				bag_button_7.setContentAreaFilled(false);
				bag_button_7.setBorderPainted(false);
				
				bag_button_8.setBounds(365, 183, 9, 10);
				bag_button_8.setOpaque(false);
				bag_button_8.setContentAreaFilled(false);
				bag_button_8.setBorderPainted(false);
				
				if(machine_time != 0 && machine_able == false)
				{
					if(times - machine_time == 40)
					{
						machine_able = true;
						machine_time = 0;
					}
				}
				
				g.drawImage(stage2.getImage(), background_x, background_y, MAP_WIDTH, MAP_HEIGHT, this);
				
				second_safe.drawObject(g2d);
				second_drawer.drawObject(g2d);
				bag.drawObject(g2d);
			
				if(pattern == 1)
				{
					magic_pattern1.drawObject(g2d);
				}
				else if(pattern == 2)
				{
					magic_pattern2.drawObject(g2d);
				}
				else if(pattern == 3)
				{
					magic_pattern3.drawObject(g2d);
				}
				
				if(machine_able == true && blue == true)
				{
					machine_blue.drawObject(g2d);
				}
				else if(machine_able == true && red == true)
				{
					machine_red.drawObject(g2d);
				}
				else if(machine_able == true && yellow == true)
				{
					machine_yellow.drawObject(g2d);
				}
				else if(machine_able == true && green == true)
				{
					machine_green.drawObject(g2d);
				}
				else if(machine_able == true && greenblue == true)
				{
					machine_greenblue.drawObject(g2d);
				}
				else if(machine_able == true && purple == true)
				{
					machine_purple.drawObject(g2d);
				}
				else if(machine_able == true && white == true)
				{
					machine_white.drawObject(g2d);
				}
				else if(machine_able == true)
				{
					machine.drawObject(g2d);
				}
				
				if(directionback == true)
				{
					g.drawImage(generalChar_front.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				else if(directionright == true)
				{
					g.drawImage(generalChar_right.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				else if(directionleft == true)
				{
					g.drawImage(generalChar_left.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				else if(directionfront == true)
				{
					g.drawImage(generalChar_back.get(charAni / 10).getImage(), char_x, char_y, 63, 90, this);
				}
				
				
				if(second_safe.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(second_safe_isopen == false)
					{
						g.drawImage(popup_second_safe_close.getImage(), 0, 0, 640, 480, this);
						popup_button_0.setBounds(428, 295, 27, 27);
						gamepanel2.add(popup_button_0);
						popup_button_1.setBounds(311, 228, 27, 27);
						gamepanel2.add(popup_button_1);
						popup_button_2.setBounds(350, 228, 27, 27);
						gamepanel2.add(popup_button_2);
						popup_button_3.setBounds(389, 228, 27, 27);
						gamepanel2.add(popup_button_3);
						popup_button_4.setBounds(311, 261, 27, 27);
						gamepanel2.add(popup_button_4);
						popup_button_5.setBounds(350, 261, 27, 27);
						gamepanel2.add(popup_button_5);
						popup_button_6.setBounds(389, 261, 27, 27);
						gamepanel2.add(popup_button_6);
						popup_button_7.setBounds(311, 295, 27, 27);
						gamepanel2.add(popup_button_7);
						popup_button_8.setBounds(350, 295, 27, 27);
						gamepanel2.add(popup_button_8);
						popup_button_9.setBounds(389, 295, 27, 27);
						gamepanel2.add(popup_button_9);
						popup_button_ok.setBounds(428, 246, 27, 43);
						gamepanel2.add(popup_button_ok);
						System.out.printf("Stack size -> %d\n", stack.size());
						
						if(password_fail == true)
						{
							g.drawImage(popup_second_wrong.getImage(), 427, 227, 29, 16, this);
							if(times - inter_time == 40)
							{
								password_fail = false;
							}
						}
					}
					else
					{
						g.drawImage(popup_second_safe_open.getImage(), 0, 0, 640, 480, this);
						gamepanel2.remove(popup_button_0);
						gamepanel2.remove(popup_button_1);
						gamepanel2.remove(popup_button_2);
						gamepanel2.remove(popup_button_3);
						gamepanel2.remove(popup_button_4);
						gamepanel2.remove(popup_button_5);
						gamepanel2.remove(popup_button_6);
						gamepanel2.remove(popup_button_7);
						gamepanel2.remove(popup_button_8);
						gamepanel2.remove(popup_button_9);
						gamepanel2.remove(popup_button_ok);
						if(bluelight_isget == false)
						{
							gamepanel2.add(blue_light);
						}
						else
						{
							gamepanel2.remove(blue_light);
						}
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel2.add(itembutton1);
					gamepanel2.add(itembutton2);
					gamepanel2.add(itembutton3);
					gamepanel2.add(itembutton4);
					gamepanel2.add(itembutton5);
					gamepanel2.add(itembutton6);
					gamepanel2.add(itembutton7);
					gamepanel2.add(closebutton1);
					gamepanel2.add(pagebutton_left);
					gamepanel2.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(second_drawer.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					if(second_drawer_isopen == false)
					{
						g.drawImage(popup_second_drawer_close.getImage(), 0, 0, 640, 480, this);
						popup_button_0.setBounds(309, 305, 24, 23);
						gamepanel2.add(popup_button_0);
						popup_button_1.setBounds(278, 218, 24, 23);
						gamepanel2.add(popup_button_1);
						popup_button_2.setBounds(309, 218, 24, 23);
						gamepanel2.add(popup_button_2);
						popup_button_3.setBounds(339, 218, 24, 23);
						gamepanel2.add(popup_button_3);
						popup_button_4.setBounds(278, 247, 24, 23);
						gamepanel2.add(popup_button_4);
						popup_button_5.setBounds(309, 247, 24, 23);
						gamepanel2.add(popup_button_5);
						popup_button_6.setBounds(339, 247, 24, 23);
						gamepanel2.add(popup_button_6);
						popup_button_7.setBounds(278, 276, 24, 23);
						gamepanel2.add(popup_button_7);
						popup_button_8.setBounds(309, 276, 24, 23);
						gamepanel2.add(popup_button_8);
						popup_button_9.setBounds(339, 276, 24, 23);
						gamepanel2.add(popup_button_9);
						popup_button_10.setBounds(278, 305, 24, 23);
						gamepanel2.add(popup_button_10);
						popup_button_11.setBounds(339, 305, 24, 23);
						gamepanel2.add(popup_button_11);
						
						if(stack.size() == 6)
						{
							for(int i = 5; i >= 0; i--)
							{
								temp = stack.pop();
								if(second_drawer_correct[i] != temp)
								{
									stack.push(temp);
								}
								else
								{
									continue;
								}
							}
							if(stack.isEmpty() == true)
							{
								pattern++;
								second_drawer_isopen = true;
								stack.init();
							}
							else
							{
								stack.init();
							}
						}
						System.out.printf("Stack size -> %d\n", stack.size());
					}
					else
					{
						g.drawImage(popup_second_drawer_open.getImage(), 0, 0, 640, 480, this);
						gamepanel2.remove(popup_button_0);
						gamepanel2.remove(popup_button_1);
						gamepanel2.remove(popup_button_2);
						gamepanel2.remove(popup_button_3);
						gamepanel2.remove(popup_button_4);
						gamepanel2.remove(popup_button_5);
						gamepanel2.remove(popup_button_6);
						gamepanel2.remove(popup_button_7);
						gamepanel2.remove(popup_button_8);
						gamepanel2.remove(popup_button_9);
						gamepanel2.remove(popup_button_10);
						gamepanel2.remove(popup_button_11);
						if(greenlight_isget == false)
						{
							gamepanel2.add(green_light);
						}
						else
						{
							gamepanel2.remove(green_light);
						}
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel2.add(itembutton1);
					gamepanel2.add(itembutton2);
					gamepanel2.add(itembutton3);
					gamepanel2.add(itembutton4);
					gamepanel2.add(itembutton5);
					gamepanel2.add(itembutton6);
					gamepanel2.add(itembutton7);
					gamepanel2.add(closebutton1);
					gamepanel2.add(pagebutton_left);
					gamepanel2.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
				}
				else if(machine.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					
					if(machine_isopen == false)
					{
						g.drawImage(popup_machine_close.getImage(), 0, 0, 640, 480, this);
						if(sun_button == true)
						{
							gamepanel2.add(sun);
						}
						else
						{
							gamepanel2.remove(sun);
						}
					}
					else
					{
						g.drawImage(popup_machine_open.getImage(), 0, 0, 640, 480, this);
						gamepanel2.remove(machine_red_button);
						gamepanel2.remove(machine_green_button);
						gamepanel2.remove(machine_blue_button);
						if(redlight_isget == false)
						{
							gamepanel2.add(machine_red_button);
						}
						if(greenlight_isget == false)
						{
							gamepanel2.add(machine_green_button);
						}
						if(bluelight_isget == false)
						{
							gamepanel2.add(machine_blue_button);
						}
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel2.add(itembutton1);
					gamepanel2.add(itembutton2);
					gamepanel2.add(itembutton3);
					gamepanel2.add(itembutton4);
					gamepanel2.add(itembutton5);
					gamepanel2.add(itembutton6);
					gamepanel2.add(itembutton7);
					gamepanel2.add(closebutton1);
					gamepanel2.add(pagebutton_left);
					gamepanel2.add(pagebutton_right);
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								if(machine_isopen == false && inventory_list.get(0).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item1_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(0).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item1_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(0).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item1_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(0).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item1_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(0).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item1_info = false;
								}
								else
								{
									g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
								}
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								if(machine_isopen == false && inventory_list.get(1).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item2_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(1).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item2_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(1).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item2_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(1).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item2_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(1).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item2_info = false;
								}
								else
								{
									g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
								}
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								if(machine_isopen == false && inventory_list.get(2).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item3_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(2).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item3_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(2).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item3_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(2).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item3_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(2).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item3_info = false;
								}
								else
								{
									g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
								}
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								if(machine_isopen == false && inventory_list.get(3).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item4_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(3).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item4_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(3).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item4_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(3).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item4_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(3).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item4_info = false;
								}
								else
								{
									g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								if(machine_isopen == false && inventory_list.get(4).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item5_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(4).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item5_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(4).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item5_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(4).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item5_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(4).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item5_info = false;
								}
								else
								{
									g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								if(machine_isopen == false && inventory_list.get(5).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item6_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(5).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item6_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(5).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item6_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(5).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item6_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(5).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item6_info = false;
								}
								else
								{
									g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								if(machine_isopen == false && inventory_list.get(6).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item7_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(6).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item7_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(6).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item7_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(6).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item7_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(6).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item7_info = false;
								}
								else
								{
									g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								if(machine_isopen == false && inventory_list.get(7).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item1_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(7).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item1_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(7).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item1_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(7).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item1_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(7).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item1_info = false;
								}
								else
								{
									g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
								}
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								if(machine_isopen == false && inventory_list.get(8).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item2_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(8).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item2_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(8).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item2_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(8).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item2_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(8).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item2_info = false;
								}
								else
								{
									g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
								}
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								if(machine_isopen == false && inventory_list.get(9).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item3_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(9).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item3_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(9).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item3_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(9).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item3_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(9).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item3_info = false;
								}
								else
								{
									g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								if(machine_isopen == false && inventory_list.get(10).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item4_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(10).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item4_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(10).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item4_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(10).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item4_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(10).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item4_info = false;
								}
								else
								{
									g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								if(machine_isopen == false && inventory_list.get(11).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item5_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(11).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item5_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(11).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item5_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(11).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item5_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(11).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item5_info = false;
								}
								else
								{
									g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								if(machine_isopen == false && inventory_list.get(12).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item6_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(12).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item6_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(12).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item6_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(12).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item6_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(12).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item6_info = false;
								}
								else
								{
									g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								if(machine_isopen == false && inventory_list.get(13).equals(paper1_icon))
								{
									for(int i = inventory_list.indexOf(paper1_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(sun_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									sun_button = true;
									sun_isget = false;
									item7_info = false;
								}
								else if(machine_isopen == false && inventory_list.get(13).equals(paper2_icon))
								{
									for(int i = inventory_list.indexOf(paper2_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(moon_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									machine_isopen = true;
									item7_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(13).equals(redlight_icon))
								{
									for(int i = inventory_list.indexOf(redlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(red_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									redlight_isget = false;
									item7_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(13).equals(bluelight_icon))
								{
									for(int i = inventory_list.indexOf(bluelight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(blue_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									bluelight_isget = false;
									item7_info = false;
								}
								else if(machine_isopen == true && inventory_list.get(13).equals(greenlight_icon))
								{
									for(int i = inventory_list.indexOf(greenlight_icon); i < inventory_list.size() - 1; i++)
									{
										inventory_list.set(i, inventory_list.get(i + 1));
									}
									inventory_list.remove(inventory_list.size() - 1);
									
									for(int i = item_information.indexOf(green_detail); i < item_information.size() - 1; i++)
									{
										item_information.set(i, item_information.get(i + 1));
									}
									item_information.remove(item_information.size() - 1);
									
									greenlight_isget = false;
									item7_info = false;
								}
								else
								{
									g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
								}
							}					
						}
					}
				}
				else if(bag.ismessage == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					
					if(bag_isopen == false)
					{
						g.drawImage(popup_bag_close.getImage(), 0, 0, 640, 480, this);
						
						g.drawImage(bag_button_first.get(bag_pw1).getImage(), 269, 183, 7, 10, this);
						g.drawImage(bag_button_second.get(bag_pw2).getImage(), 282, 183, 7, 10, this);
						g.drawImage(bag_button_third.get(bag_pw3).getImage(), 295, 183, 7, 10, this);
						g.drawImage(bag_button_fourth.get(bag_pw4).getImage(), 309, 183, 7, 10, this);
						g.drawImage(bag_button_fifth.get(bag_pw5).getImage(), 324, 183, 7, 10, this);
						g.drawImage(bag_button_sixth.get(bag_pw6).getImage(), 338, 183, 7, 10, this);
						g.drawImage(bag_button_seventh.get(bag_pw7).getImage(), 351, 183, 7, 10, this);
						g.drawImage(bag_button_eighth.get(bag_pw8).getImage(), 365, 183, 9, 10, this);
						
						gamepanel2.add(bag_button_1);
						gamepanel2.add(bag_button_2);
						gamepanel2.add(bag_button_3);
						gamepanel2.add(bag_button_4);
						gamepanel2.add(bag_button_5);
						gamepanel2.add(bag_button_6);
						gamepanel2.add(bag_button_7);
						gamepanel2.add(bag_button_8);
						
						if(bag_pw1 == 1 && bag_pw2 == 6 && bag_pw3 == 2 && bag_pw4 == 0 && bag_pw5 == 0 && bag_pw6 == 3 && bag_pw7 == 8 && bag_pw8 == 7)
						{
							pattern++;
							bag_isopen = true;
						}
					}
					else
					{
						gamepanel2.remove(bag_button_1);
						gamepanel2.remove(bag_button_2);
						gamepanel2.remove(bag_button_3);
						gamepanel2.remove(bag_button_4);
						gamepanel2.remove(bag_button_5);
						gamepanel2.remove(bag_button_6);
						gamepanel2.remove(bag_button_7);
						gamepanel2.remove(bag_button_8);
						
						g.drawImage(popup_bag_open.getImage(), 0, 0, 640, 480, this);
						if(moon_isget == false)
						{
							gamepanel2.add(moon);	
						}
						else
						{
							gamepanel2.remove(moon);
						}
					}
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel2.add(itembutton1);
					gamepanel2.add(itembutton2);
					gamepanel2.add(itembutton3);
					gamepanel2.add(itembutton4);
					gamepanel2.add(itembutton5);
					gamepanel2.add(itembutton6);
					gamepanel2.add(itembutton7);
					gamepanel2.add(pagebutton_left);
					gamepanel2.add(pagebutton_right);
					
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
					
					gamepanel2.add(closebutton1);
				}
				else if(inventory == true)
				{
					movefront = false;
					moveback = false;
					moveleft = false;
					moveright = false;
					g.drawImage(inven.getImage(), 0, 0, 640, 480, this);
					
					for(int i = (inventory_page * 7) - 7; i < inventory_list.size() && i < (inventory_page * 7); i++)
					{
						g.drawImage(inventory_list.get(i).getImage(), inventory_x + ((i - ((inventory_page - 1) * 7)) * 60), inventory_y, 40, 40, this);
					}
					gamepanel2.add(itembutton1);
					gamepanel2.add(itembutton2);
					gamepanel2.add(itembutton3);
					gamepanel2.add(itembutton4);
					gamepanel2.add(itembutton5);
					gamepanel2.add(itembutton6);
					gamepanel2.add(itembutton7);
					gamepanel2.add(pagebutton_left);
					gamepanel2.add(pagebutton_right);
					
					if(inventory_page == 1)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 0)
							{
								g.drawImage(item_information.get(0).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 1)
							{
								g.drawImage(item_information.get(1).getImage(), 0, -40, 640, 480, this);
						
							}						
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 2)
							{
								g.drawImage(item_information.get(2).getImage(), 0, -40, 640, 480, this);
						
							}
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 3)
							{
								g.drawImage(item_information.get(3).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 4)
							{
								g.drawImage(item_information.get(4).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 5)
							{
								g.drawImage(item_information.get(5).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 6)
							{
								g.drawImage(item_information.get(6).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
					}
					else if(inventory_page == 2)
					{
						if(item1_info == true)
						{
							if(inventory_list.size() > 7)
							{
								g.drawImage(item_information.get(7).getImage(), 0, -40, 640, 480, this);
						
							}				
						}
						else if(item2_info == true)
						{
							if(inventory_list.size() > 8)
							{
								g.drawImage(item_information.get(8).getImage(), 0, -40, 640, 480, this);
						
							}			
						}
						else if(item3_info == true)
						{
							if(inventory_list.size() > 9)
							{
								g.drawImage(item_information.get(9).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item4_info == true)
						{
							if(inventory_list.size() > 10)
							{
								g.drawImage(item_information.get(10).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item5_info == true)
						{
							if(inventory_list.size() > 11)
							{
								g.drawImage(item_information.get(11).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item6_info == true)
						{
							if(inventory_list.size() > 12)
							{
								g.drawImage(item_information.get(12).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
						else if(item7_info == true)
						{
							if(inventory_list.size() > 13)
							{
								g.drawImage(item_information.get(13).getImage(), 0, -40, 640, 480, this);
						
							}					
						}
					}
					
					gamepanel2.add(closebutton1);
				}
				else
				{
					gamepanel2.remove(closebutton1);
					gamepanel2.remove(itembutton1);
					gamepanel2.remove(itembutton2);
					gamepanel2.remove(itembutton3);
					gamepanel2.remove(itembutton4);
					gamepanel2.remove(itembutton5);
					gamepanel2.remove(itembutton6);
					gamepanel2.remove(itembutton7);
					gamepanel2.remove(pagebutton_left);
					gamepanel2.remove(pagebutton_right);
					gamepanel2.remove(popup_button_0);
					gamepanel2.remove(popup_button_1);
					gamepanel2.remove(popup_button_2);
					gamepanel2.remove(popup_button_3);
					gamepanel2.remove(popup_button_4);
					gamepanel2.remove(popup_button_5);
					gamepanel2.remove(popup_button_6);
					gamepanel2.remove(popup_button_7);
					gamepanel2.remove(popup_button_8);
					gamepanel2.remove(popup_button_9);
					gamepanel2.remove(popup_button_ok);
					gamepanel2.remove(popup_button_x);
					gamepanel2.remove(popup_button_10);
					gamepanel2.remove(popup_button_11);
					gamepanel2.remove(blue_light);
					gamepanel2.remove(green_light);
					gamepanel2.remove(sun);
					gamepanel2.remove(moon);
					gamepanel2.remove(machine_red_button);
					gamepanel2.remove(machine_green_button);
					gamepanel2.remove(machine_blue_button);
					gamepanel2.remove(bag_button_1);
					gamepanel2.remove(bag_button_2);
					gamepanel2.remove(bag_button_3);
					gamepanel2.remove(bag_button_4);
					gamepanel2.remove(bag_button_5);
					gamepanel2.remove(bag_button_6);
					gamepanel2.remove(bag_button_7);
					gamepanel2.remove(bag_button_8);
				}
			}
			
			goChar.start();
			goTime.start();
			
			gamepanel2.setFocusable(true);
			gamepanel2.requestFocus();
			frame.repaint();
			frame.setVisible(true);
		}
	}
	
	class itemInfoListener1 implements MouseListener //각 아이템 목록 페이지의 첫번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item1_info == false)
			{
				item5_info = false;
				item2_info = false;
				item3_info = false;
				item4_info = false;
				item1_info = true;
				item6_info = false;
				item7_info = false;
			}
			else
			{
				item1_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class itemInfoListener2 implements MouseListener//각 아이템 목록 페이지의 두번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item2_info == false)
			{
				item1_info = false;
				item3_info = false;
				item4_info = false;
				item5_info = false;
				item2_info = true;
				item6_info = false;
				item7_info = false;
			}
			else
			{
				item2_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class itemInfoListener3 implements MouseListener//각 아이템 목록 페이지의 세번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item3_info == false)
			{
				item1_info = false;
				item2_info = false;
				item4_info = false;
				item5_info = false;
				item3_info = true;
				item6_info = false;
				item7_info = false;
			}
			else
			{
				item3_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class itemInfoListener4 implements MouseListener//각 아이템 목록 페이지의 네번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item4_info == false)
			{	
				item1_info = false;
				item2_info = false;
				item3_info = false;
				item5_info = false;
				item4_info = true;
				item6_info = false;
				item7_info = false;
			}
			else
			{
				item4_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class itemInfoListener5 implements MouseListener//각 아이템 목록 페이지의 다섯번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item5_info == false)
			{
				item1_info = false;
				item2_info = false;
				item3_info = false;
				item4_info = false;
				item5_info = true;
				item6_info = false;
				item7_info = false;
			}
			else
			{
				item5_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class itemInfoListener6 implements MouseListener//각 아이템 목록 페이지의 여섯번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item5_info == false)
			{
				item1_info = false;
				item2_info = false;
				item3_info = false;
				item4_info = false;
				item5_info = false;
				item6_info = true;
				item7_info = false;
			}
			else
			{
				item6_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class itemInfoListener7 implements MouseListener//각 아이템 목록 페이지의 일곱번째 항목의 상세정보
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(item5_info == false)
			{
				item1_info = false;
				item2_info = false;
				item3_info = false;
				item4_info = false;
				item5_info = false;
				item6_info = false;
				item7_info = true;
			}
			else
			{
				item7_info = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class rightListener implements MouseListener //아이템 목록 페이지 이동
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(inventory_page != ((inventory_list.size() - 1) / 7) + 1)
			{
				inventory_page++;
			}
			item1_info = false;
			item2_info = false;
			item3_info = false;
			item4_info = false;
			item5_info = false;
			item6_info = false;
			item7_info = false;
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class leftListener implements MouseListener//아이템 목록 페이지 이동
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(inventory_page != 1)
			{
				inventory_page--;
			}
			item1_info = false;
			item2_info = false;
			item3_info = false;
			item4_info = false;
			item5_info = false;
			item6_info = false;
			item7_info = false;
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class closeListener1 implements MouseListener //팝업창 닫는 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			inventory = false;
			kettle.ismessage = false;
			drawer.ismessage = false;
			sofa.ismessage = false;
			round_desk.ismessage = false;
			marimba.ismessage = false;
			magic_paper1.ismessage = false;
			cabinet_close_glass.ismessage = false;
			safe_ismessage = false;
			door_ismessage = false;
			bookshelf.ismessage = false;
			square_desk.ismessage = false;
			broom_dust.ismessage = false;
			box.ismessage = false;
			second_safe.ismessage = false;
			second_drawer.ismessage = false;
			machine.ismessage = false;
			bag.ismessage = false;
			bookshelf_left = false;
			bookshelf_right = false;
			drawer_left = false; 
			drawer_right = false;
			box_isopen = false;
			door_desert = false;
			door_black = false;
			item1_info = false;
			item2_info = false;
			item3_info = false;
			item4_info = false;
			item5_info = false;
			item6_info = false;
			item7_info = false;
			inventory_page = 1;
			door_marble.set(0, popup_marble_yellow);
			door_marble.set(1, popup_marble_red);
			door_marble.set(2, popup_marble_black);
			door_marble.set(3, popup_marble_black);
			stack.init();
			
			if(pattern == 3 && machine_able == false)
			{
				machine_time = times;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	//각종 상호작용 버튼 리스너
	class goriListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(box_isopen == false)
			{
				box_isopen = true;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class drawerleftListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(drawer_left == false)
			{
				drawer_left = true;
				
			}
			else
			{
				drawer_left = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class drawerrightListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(drawer_right == false)
			{
				drawer_right = true;
				
			}
			else
			{
				drawer_right = false;
				stack.init();
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class bookleftListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bookshelf_left == false)
			{
				bookshelf_left = true;
				
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class bookrightListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bookshelf_right == false)
			{
				bookshelf_right = true;
				
			}
			else
			{
				bookshelf_right = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class carpetListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(magic_paper1.isget == false)
			{
				magic_paper1.isget = true;
				inventory_list.add(paper1_icon);
				item_information.add(sun_detail);
				sun_isget = true;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class change1Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(door_black == false && door_desert == false)
			{
				door_marble.set(3, door_marble.get(0));
				door_marble.set(0, door_marble.get(1));
				door_marble.set(1, door_marble.get(3));
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class change2Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(door_black == false && door_desert == false)
			{
				door_marble.set(3, door_marble.get(1));
				door_marble.set(1, door_marble.get(2));
				door_marble.set(2, door_marble.get(3));
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class change3Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(door_black == false && door_desert == false)
			{
				door_marble.set(3, door_marble.get(0));
				door_marble.set(0, door_marble.get(2));
				door_marble.set(2, door_marble.get(3));
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class okListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(door_marble.get(0).equals(popup_marble_black) && door_marble.get(1).equals(popup_marble_yellow) && door_marble.get(2).equals(popup_marble_red))
			{
				door_black = true;
			}
			else if(door_marble.get(0).equals(popup_marble_red) && door_marble.get(1).equals(popup_marble_yellow) && door_marble.get(2).equals(popup_marble_black))
			{
				door_desert = true;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class lullabyListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(lullaby_isget == false)
			{
				lullaby_isget = true;
				inventory_list.add(lullaby_icon);
				item_information.add(lullaby_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class musicListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(sheet_isget == false)
			{
				sheet_isget = true;
				inventory_list.add(sheet_icon);
				item_information.add(sheet_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keyListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(key_isget == false)
			{
				key_isget = true;
				inventory_list.add(key_icon);
				item_information.add(key_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class cushionListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cushion_up == false)
			{
				cushion_up = true;
			}
			else
			{
				cushion_up = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class sunListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(sun_isget == false)
			{
				sun_isget = true;
				inventory_list.add(paper1_icon);
				item_information.add(sun_detail);
				sun_button = false;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class moonListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(moon_isget == false)
			{
				moon_isget = true;
				inventory_list.add(paper2_icon);
				item_information.add(moon_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class redListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(red_marble_isget == false)
			{
				red_marble_isget = true;
				inventory_list.add(marble_red_icon);
				item_information.add(marble_red_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class spoonListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(spoon_isget == false)
			{
				spoon_isget = true;
				inventory_list.add(spoon_icon);
				item_information.add(spoon_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class cabihintListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_hint_isget == false)
			{
				cabinet_hint_isget = true;
				inventory_list.add(cabinet_icon);
				item_information.add(cabinet_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class redlightListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(redlight_isget == false)
			{
				redlight_isget = true;
				inventory_list.add(redlight_icon);
				item_information.add(red_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class bluelightListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bluelight_isget == false)
			{
				bluelight_isget = true;
				inventory_list.add(bluelight_icon);
				item_information.add(blue_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class greenlightListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(greenlight_isget == false)
			{
				greenlight_isget = true;
				inventory_list.add(greenlight_icon);
				item_information.add(green_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class recipeListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(recipe_isget == false)
			{
				recipe_isget = true;
				inventory_list.add(recipe_icon);
				item_information.add(medicine_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class doorListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(door_hint_isget == false)
			{
				door_hint_isget = true;
				inventory_list.add(door_icon);
				item_information.add(door_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class yellowListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(yellow_marble_isget == false)
			{
				yellow_marble_isget = true;
				inventory_list.add(marble_yellow_icon);
				item_information.add(marble_yellow_detail);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class dustListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(broom_isclear == false)
			{
				if(glass_isget == true && redlight_isget == true)
				{
					broom_isclear = true;
					inventory_list.set(inventory_list.indexOf(glass_icon), glass_dust_icon);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class bag1Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw1 == 9)
			{
				bag_pw1 = 0;
			}
			else
			{
				bag_pw1++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag2Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw2 == 9)
			{
				bag_pw2 = 0;
			}
			else
			{
				bag_pw2++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag3Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw3 == 9)
			{
				bag_pw3 = 0;
			}
			else
			{
				bag_pw3++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag4Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw4 == 9)
			{
				bag_pw4 = 0;
			}
			else
			{
				bag_pw4++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag5Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw5 == 9)
			{
				bag_pw5 = 0;
			}
			else
			{
				bag_pw5++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag6Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw6 == 9)
			{
				bag_pw6 = 0;
			}
			else
			{
				bag_pw6++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag7Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw7 == 9)
			{
				bag_pw7 = 0;
			}
			else
			{
				bag_pw7++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	class bag8Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(bag_pw8 == 9)
			{
				bag_pw8 = 0;
			}
			else
			{
				bag_pw8++;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad0Listener implements MouseListener //키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(0);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(0);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(0);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(0);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad1Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(1);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(1);
				}
			}
			else if(drawer.ismessage == true && drawer_right_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(1);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(1);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(1);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad2Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(2);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(2);
				}
			}
			else if(drawer.ismessage == true && drawer_right_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(2);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(2);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(2);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad3Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(3);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(3);
				}
			}
			else if(drawer.ismessage == true && drawer_right_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(3);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(3);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(3);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad4Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(4);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(4);
				}
			}
			else if(drawer.ismessage == true && drawer_right_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(4);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(4);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(4);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad5Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(5);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(5);
				}
			}
			else if(drawer.ismessage == true && drawer_right_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(5);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(5);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(5);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad6Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(6);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(6);
				}
			}
			else if(drawer.ismessage == true && drawer_right_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(6);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(6);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(6);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad7Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(7);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(7);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(7);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(7);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad8Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(8);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(8);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(8);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(8);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad9Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(9);
				}
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				if(stack.size() < 7)
				{
					stack.push(9);
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && password_fail == false)
			{
				if(stack.size() < 4)
				{
					stack.push(9);
				}
			}
			else if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(9);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad10Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(10);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypad11Listener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(second_drawer.ismessage == true && second_drawer_isopen == false)
			{
				if(stack.size() < 6)
				{
					stack.push(11);
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypadokListener implements MouseListener//키패드 리스너
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && stack.size() >= 1)
			{
				if(stack.size() == 4) //비밀번호는 4자리
				{
					for(int i = 3; i >= 0; i--)
					{
						temp = stack.pop(); //스택에서 하나 빼옴
						if(cabinet_correct[i] != temp) //배열의 뒤에서부터 검사(선입후출)
						{
							stack.push(temp); //다르면 빼온걸 다시 집어넣음
						}
						else
						{
							continue; //같으면 그대로 반복
						}
					}
				}
				if(stack.isEmpty() == true) //만약에 정답이면 스택이 비어있게 됨
				{
					cabinet_isopen = true;
					stack.init(); //스택 초기화
				}
				else
				{
					password_fail = true; //틀렸다는 메세지 출력
					inter_time = times;
					stack.init(); //스택 초기화
				}
			}
			else if(safe_ismessage == true && safe_isopen == false && stack.size() >= 1)
			{
				if(stack.size() == 7)
				{
					for(int i = 6; i >= 0; i--)
					{
						temp = stack.pop();
						if(safe_correct[i] != temp)
						{
							stack.push(temp);
						}
						else
						{
							continue;
						}
					}
				}
				if(stack.isEmpty() == true)
				{
					safe_isopen = true;
					stack.init();
				}
				else
				{
					stack.init();
				}
			}
			else if(second_safe.ismessage == true && second_safe_isopen == false && stack.size() >= 1)
			{
				if(stack.size() == 4)
				{
					for(int i = 3; i >= 0; i--)
					{
						temp = stack.pop();
						if(second_safe_correct[i] != temp)
						{
							stack.push(temp);
						}
						else
						{
							continue;
						}
					}
				}
				if(stack.isEmpty() == true)
				{
					second_safe_isopen = true;
					stack.init();
					pattern++;
				}
				else
				{
					password_fail = true;
					inter_time = times;
					stack.init();
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class keypadxListener implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			if(cabinet_close_glass.ismessage == true && cabinet_isopen == false && password_fail == false)
			{
				temp = stack.pop();
			}
			else if(safe_ismessage == true && safe_isopen == false)
			{
				temp = stack.pop();
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class DirectionListener implements KeyListener
	{
		public void keyPressed (KeyEvent event) 
		{
			int keycode = event.getKeyCode();
			
			if(inventory == false && kettle.ismessage == false)
			{
				if(keycode == KeyEvent.VK_UP)
				{
						movefront = true;
				}
				if(keycode == KeyEvent.VK_DOWN)
				{
						moveback = true;
				}
				if(keycode == KeyEvent.VK_RIGHT)
				{
						moveright = true;
				}
				if(keycode == KeyEvent.VK_LEFT)
				{
						moveleft = true;
				}
			}
		}
		public void keyTyped (KeyEvent event) {}
		public void keyReleased (KeyEvent event)
		{
			int keycode = event.getKeyCode();
			
			if(keycode == KeyEvent.VK_UP)
			{
				movefront = false;
			}
			if(keycode == KeyEvent.VK_DOWN)
			{
				moveback = false;
			}
			if(keycode == KeyEvent.VK_RIGHT)
			{
				moveright = false;
			}
			if(keycode == KeyEvent.VK_LEFT)
			{
				moveleft = false;
			}
			
			if(inventory == false)
			{
				if(keycode == KeyEvent.VK_SPACE)
				{
					if(kettle.backtouched == true || kettle.fronttouched == true || kettle.lefttouched == true || kettle.righttouched == true)
					{
						kettle.ismessage = true;
					}
					else if(drawer.lefttouched == true)
					{
						drawer.ismessage = true;
					}
					else if(round_desk.backtouched == true || round_desk.fronttouched == true || round_desk.righttouched == true || round_desk.lefttouched == true)
					{
						round_desk.ismessage = true;
					}
					else if(marimba.backtouched == true || marimba.fronttouched == true || marimba.lefttouched == true || marimba.righttouched == true)
					{
						marimba.ismessage = true;
					}
					else if(box.lefttouched == true)
					{
						box.ismessage = true;
					}
					else if(bookshelf.backtouched == true)
					{
						bookshelf.ismessage = true;
					}
					else if(square_desk.backtouched == true)
					{
						square_desk.ismessage = true;
					}
					else if(magic_paper1.backtouched == true || magic_paper1.fronttouched == true || magic_paper1.lefttouched == true || magic_paper1.righttouched == true)
					{
						if(magic_paper1.isget == false)
						{
							magic_paper1.ismessage = true;
						}
					}
					else if(cabinet_close_glass.backtouched == true || cabinet_close_glass.fronttouched == true || cabinet_close_glass.lefttouched == true || cabinet_close_glass.righttouched == true)
					{
						if(cabinet_isopen == false)
						{
							cabinet_close_glass.ismessage = true;
						}
						else
						{
							if(char_x < 60 && glass_isget == false)
							{
								glass_isget = true;
								black_marble_isget = true;
								inventory_list.add(glass_icon);
								item_information.add(glass_detail);
								inventory_list.add(marble_black_icon);
								item_information.add(marble_black_detail);
							}
							else if(char_x >= 60)
							{
								safe_ismessage = true;
							}
						}
					}
					else if(char_y < 115)
					{
							door_ismessage = true;
					}
					else if(sofa.righttouched == true)
					{
						sofa.ismessage = true;
					}
					else if(broom_dust.backtouched == true || broom_dust.fronttouched == true || broom_dust.lefttouched == true || broom_dust.righttouched == true)
					{
						broom_dust.ismessage = true;
					}
					else if(second_safe.backtouched == true)
					{
						second_safe.ismessage = true;
					}
					else if(second_drawer.backtouched == true)
					{
						second_drawer.ismessage = true;
					}
					else if(machine.backtouched == true && machine_able == true)
					{
						machine.ismessage = true;
					}
					else if(bag.backtouched == true)
					{
						bag.ismessage = true;
					}
				}
			}
		
			if(keycode == KeyEvent.VK_E)
			{
				inventory = true;
			}
		}
	}
}