package tech.lq0.providencraft.tools;

public enum Livers {
    MITSUKI("mitsuki","zero","#F9E7E8"),
    USA("usa","zero","#FFEDFE"),
    MADOKA("madoka","first","#F4F0FF"),
    MYANNA("myanna","first","#EAF6EE"),
    NIINA("niina","first","#FCDEE3"),
    UNIA("unia","first","#D2C5F9"),
    AYELET("ayelet","first","#EDF4FF"),
    MARI("mari","first","#F8F1F9"),
    HAYA("haya","first","#F3EDFF"),
    MUMU("mumu","second","#FFEEEA"),
    LECIA("lecia","second","#E1EDFF"),
    SATOU("satou","second","#E7D2E1"),
    LUCIA("lucia","second","#F6F6F6"),
    LOUISE("louise","second","#E8FFE7"),
    CHIRAM("chiram","magicros","#FFECE7"),
    HAINE("haine","magicros","#ADDBFF"),
    KERORO("keroro","magicros","#F5FFEA"),
    EKIRA("ekira","magicros","#FFF7EA"),
    HIRU("hiru","third","#68B9F6"),
    BENI("beni","third","#E26C64"),
    YUKI("yuki","third","#B4CEE3"),
    LECIEL("leciel","third","#FCBBB1"),
    SHIRAKO("shirako","poi","#F4ADB4"),
    SORAYO("sorayo","poi","#FC96A1"),
    MIYA("miya","poi","#F9F0D8"),
    AOI("aoi","poi","#EEEEEE"),
    AYU("ayu","poi","#A9BBD9"),
    YURI("yuri","poi","#F9C8DE"),
    FUKAMI("fukami", "poi", "#E0D7F5"),
    MARIA("maria","first","#AF4657"),
    MOJUKO("mojuko","second","#FFF6F9");

    private final String name;
    private final String gen;
    private final String color;

    Livers(String name, String gen, String color) {
        this.name = name;
        this.gen = gen;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getGen() {
        return gen;
    }

    public String getColor() {
        return color;
    }
}
