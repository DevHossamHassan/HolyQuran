package me.branded.hossamhassan.holyquran.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HossamHassan on 12/28/2015.
 */
public class HolyQuranSora {

    public static final List<Sora> ITEMS = new ArrayList<>();
    public static final Map<String, Sora> ITEMS_MAP = new HashMap<>();
    public static final int COUNT = 114;
    public static String[] soraNames = new String[]{"الفاتحة"
            , "البقرة"
            , "آل عمران"
            , "النساء"
            , "المائدة"
            , "الأنعام"
            , "الأعراف"
            , "الأنفال"
            , "التوبة"
            , "يونس"
            , "هود"
            , "يوسف"
            , "الرعد"
            , "إبراهيم"
            , "الحجر"
            , "النحل"
            , "الإسراء"
            , "الكهف"
            , "مريم"
            , "طه"
            , "الأنبياء"
            , "الحج"
            , "المؤمنون"
            , "النور"
            , "الفرقان"
            , "الشعراء"
            , "النمل"
            , "القصص"
            , "العنكبوت"
            , "الروم"
            , "لقمان"
            , "السجدة"
            , "الأحزاب"
            , "سبأ"
            , "فاطر"
            , "يس"
            , "الصافات"
            , "ص"
            , "الزمر"
            , "غافر"
            , "فصلت"
            , "الشورى"
            , "الزخرف"
            , "الدخان"
            , "الجاثية"
            , "الأحقاف"
            , "محمد"
            , "الفتح"
            , "الحجرات"
            , "ق"
            , "الذاريات"
            , "الطور"
            , "النجم"
            , "القمر"
            , "الرحمن"
            , "الواقعة"
            , "الحديد"
            , "المجادلة"
            , "الحشر"
            , "الممتحنة"
            , "الصف"
            , "الجمعة"
            , "المنافقون"
            , "التغابن"
            , "الطلاق"
            , "التحريم"
            , "الملك"
            , "القلم"
            , "الحاقة"
            , "المعارج"
            , "نوح"
            , "الجن"
            , "المزّمل"
            , "المدّثر"
            , "القيامة"
            , "الإنسان"
            , "المرسلات"
            , "النبأ"
            , "النازعات"
            , "عبس"
            , "التكوير"
            , "الإنفطار"
            , "المطففين"
            , "الانشقاق"
            , "البروج"
            , "الطارق"
            , "الأعلى"
            , "الغاشية"
            , "الفجر"
            , "البلد"
            , "الشمس"
            , "الليل"
            , "الضحى"
            , "الشرح"
            , "التين"
            , "العلق"
            , "القدر"
            , "البينة"
            , "الزلزلة"
            , "العاديات"
            , "القارعة"
            , "التكاثر"
            , "العصر"
            , "الهُمَزة"
            , "الفيل"
            , "قريش"
            , "الماعون"
            , "الكوثر"
            , "الكافرون"
            , "النصر"
            , "المسد"
            , "الإخلاص"
            , "الفلق"
            , "الناس"
    };
    private static int[] pageNum = new int[]{1,
            2,
            50,
            77,
            106,
            128,
            151,
            177,
            187,
            208,
            221,
            235,
            249,
            255,
            262,
            267,
            282,
            293,
            305,
            312,
            322,
            332,
            342,
            350,
            359,
            367,
            377,
            385,
            396,
            404,
            411,
            415,
            418,
            428,
            434,
            440,
            446,
            453,
            458,
            467,
            477,
            483,
            489,
            496,
            499,
            502,
            507,
            511,
            515,
            518,
            520,
            523,
            526,
            528,
            531,
            534,
            537,
            542,
            545,
            549,
            551,
            553,
            554,
            556,
            558,
            560,
            562,
            564,
            566,
            568,
            570,
            572,
            574,
            575,
            577,
            578,
            580,
            582,
            583,
            585,
            586,
            587,
            587,
            589,
            590,
            591,
            591,
            592,
            593,
            594,
            595,
            595,
            596,
            596,
            597,
            597,
            598,
            598,
            599,
            599,
            600,
            600,
            601,
            601,
            601,
            602,
            602,
            602,
            603,
            603,
            603,
            604,
            604,
            604,
    };
    public static int[] pageSize = new int[]{
            7,
            286,
            200,
            176,
            120,
            165,
            206,
            75,
            129,
            109,
            123,
            111,
            43,
            52,
            99,
            128,
            111,
            110,
            98,
            135,
            112,
            78,
            118,
            64,
            77,
            227,
            93,
            88,
            69,
            60,
            34,
            30,
            73,
            54,
            45,
            83,
            181,
            88,
            75,
            85,
            54,
            53,
            89,
            59,
            37,
            35,
            38,
            29,
            18,
            45,
            60,
            49,
            62,
            55,
            78,
            96,
            29,
            22,
            24,
            13,
            14,
            11,
            11,
            18,
            12,
            12,
            30,
            52,
            52,
            44,
            28,
            28,
            20,
            56,
            40,
            31,
            50,
            40,
            46,
            42,
            29,
            19,
            36,
            25,
            22,
            17,
            19,
            26,
            30,
            20,
            15,
            21,
            11,
            8,
            8,
            19,
            5,
            8,
            8,
            11,
            11,
            8,
            3,
            9,
            5,
            4,
            7,
            3,
            6,
            3,
            5,
            4,
            5,
            6};


    public HolyQuranSora() {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createSorasItems(i));
        }

    }

    private static Sora createSorasItems(int position) {
        return new Sora(position + 1, soraNames[position], pageNum[position], pageSize[position]);
    }

    private static void addItem(Sora item) {
        ITEMS.add(item);
        ITEMS_MAP.put(item.id + "", item);
    }

    public static class Sora {
        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public int getPageNum() {
            return pageNum;
        }

        public int getMakeya() {
            return makeya;
        }

        public int getSoraAyatNum() {
            return soraAyatNum;
        }

        public int getChapterNum() {
            return chapterNum;
        }

        public final int id;
        public final String name;
        public final int pageNum;
        public final int soraAyatNum;
        public final int makeya;
        public final int chapterNum;


        public Sora(int id, String name, int pageNum, int soraAyatNum) {
            this.id = id;
            this.name = name;
            this.pageNum = pageNum;
            this.soraAyatNum = soraAyatNum;
            this.makeya = 0;
            this.chapterNum = 0;

        }


    }
}
