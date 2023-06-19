/*
 * Copyright 2014 handsomezhou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pinyinsearch.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import com.pinyinsearch.model.PinyinSearchUnit;
import com.pinyinsearch.model.PinyinUnit;
import com.pinyinsearch.model.PinyinBaseUnit;

public class PinyinUtil {

	private static Map<String, String> mStrToPinYinMap = new HashMap<>(280);

	static {
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("20164", 16))), "xi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("20676", 16))), "ou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("20cd0", 16))), "bang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2139a", 16))), "pian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("21413", 16))), "kang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("235cb", 16))), "dang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("23c97", 16))), "wei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("23c98", 16))), "wu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("23e23", 16))), "fen");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("249db", 16))), "di");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("24a7d", 16))), "huan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("24ac9", 16))), "xie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("25532", 16))), "e");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("25562", 16))), "cao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("255a8", 16))), "zao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("25ed7", 16))), "cha");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("26221", 16))), "xu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2648d", 16))), "tong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("26676", 16))), "gu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2677c", 16))), "lv");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("26b5c", 16))), "zhi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("26c21", 16))), "na");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("27ff9", 16))), "mu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28408", 16))), "guang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28678", 16))), "qi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28695", 16))), "bian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("287e0", 16))), "que");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28b49", 16))), "ban");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28c47", 16))), "qiu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28c4f", 16))), "da");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28c51", 16))), "huang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28c54", 16))), "zun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("28e99", 16))), "ni");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("29f7e", 16))), "an");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("29f83", 16))), "mian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("29f8c", 16))), "kang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2a7dd", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2a8fb", 16))), "lou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2a917", 16))), "liao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2aa30", 16))), "qu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2aa36", 16))), "she");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2aa58", 16))), "yan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2afa2", 16))), "xian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b127", 16))), "yan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b128", 16))), "chi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b137", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b138", 16))), "xun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b1ed", 16))), "wei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b300", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b363", 16))), "tong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b36f", 16))), "xian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b372", 16))), "xiao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b37d", 16))), "xuan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b404", 16))), "yue");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b410", 16))), "ni");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b413", 16))), "rou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b461", 16))), "meng");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b4e7", 16))), "fu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b4ef", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b4f6", 16))), "xuan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b4f9", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b50d", 16))), "fan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b50e", 16))), "jue");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b536", 16))), "nie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b5ae", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b5af", 16))), "fu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b5b3", 16))), "yun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b5e7", 16))), "su");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b5f4", 16))), "zhan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b61c", 16))), "wen");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b61d", 16))), "jue");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b626", 16))), "tao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b627", 16))), "lu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b628", 16))), "ti");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b62a", 16))), "yuan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b62c", 16))), "xi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b695", 16))), "shi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b696", 16))), "ci");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b6ad", 16))), "lie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b6ed", 16))), "kuang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b7a9", 16))), "men");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b7c5", 16))), "liang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b7e6", 16))), "sui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b7f9", 16))), "hong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b7fc", 16))), "da");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b806", 16))), "kui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b80a", 16))), "xuan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b81c", 16))), "ni");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2b8b8", 16))), "dan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bac7", 16))), "e");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bb5f", 16))), "qu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bb62", 16))), "lun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bb7c", 16))), "lao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bb83", 16))), "shan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bc1b", 16))), "xing");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bd77", 16))), "li");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bd87", 16))), "die");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2bdf7", 16))), "xin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2be29", 16))), "kou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c029", 16))), "wei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c02a", 16))), "xian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c0a9", 16))), "jia");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c0ca", 16))), "zhi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c1d5", 16))), "wan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c1d9", 16))), "pei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c1f9", 16))), "guo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c27c", 16))), "ou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c288", 16))), "xun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c2a4", 16))), "chan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c317", 16))), "he");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c35b", 16))), "li");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c361", 16))), "dang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c364", 16))), "xun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c488", 16))), "que");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c494", 16))), "geng");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c497", 16))), "lan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c542", 16))), "long");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c613", 16))), "xun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c618", 16))), "dan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c621", 16))), "yin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c629", 16))), "ting");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c62b", 16))), "huan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c62c", 16))), "qian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c62d", 16))), "chen");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c62f", 16))), "zhun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c642", 16))), "yan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c64a", 16))), "mo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c64b", 16))), "xiang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c72c", 16))), "man");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c72f", 16))), "liang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c79f", 16))), "pin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c7c1", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c7fd", 16))), "dong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c8d9", 16))), "xu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c8de", 16))), "zhu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c8e1", 16))), "jian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c8f3", 16))), "hen");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c907", 16))), "yin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c90a", 16))), "shi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2c91d", 16))), "hui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ca02", 16))), "qi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ca0e", 16))), "you");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ca7d", 16))), "xun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2caa9", 16))), "nong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb29", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb2d", 16))), "lun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb2e", 16))), "chang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb31", 16))), "jin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb38", 16))), "shu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb39", 16))), "shen");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb3b", 16))), "lu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb3f", 16))), "zhao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb41", 16))), "mu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb4a", 16))), "du");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb4e", 16))), "hong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb5a", 16))), "chun");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb5b", 16))), "bo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb64", 16))), "hou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb69", 16))), "weng");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb6c", 16))), "wei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb6f", 16))), "pie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb73", 16))), "xi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb76", 16))), "hei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb78", 16))), "lin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cb7c", 16))), "sui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cbb1", 16))), "yin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cbbf", 16))), "gai");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cbc0", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cbce", 16))), "tui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cc56", 16))), "di");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cc5f", 16))), "wei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ccf5", 16))), "pi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ccf6", 16))), "jiong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ccfd", 16))), "shen");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ccff", 16))), "tu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd02", 16))), "fei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd03", 16))), "huo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd0a", 16))), "lin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd8b", 16))), "ju");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd8d", 16))), "tuo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd8f", 16))), "wei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd90", 16))), "zhao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cd9f", 16))), "la");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cda0", 16))), "lian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cda8", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cdad", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cdae", 16))), "xi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2cdd5", 16))), "bu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce18", 16))), "yan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce1a", 16))), "yue");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce23", 16))), "xian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce26", 16))), "zhuo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce2a", 16))), "fan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce7c", 16))), "xie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce88", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("2ce93", 16))), "chu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fa6", 16))), "chang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fa7", 16))), "shu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fa8", 16))), "huai");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fa9", 16))), "jin");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9faa", 16))), "zhan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fab", 16))), "gan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fac", 16))), "wang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fad", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fae", 16))), "ji");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9faf", 16))), "yue");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fb0", 16))), "zou");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fb1", 16))), "si");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fb2", 16))), "ku");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fb3", 16))), "lu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fbc", 16))), "rui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fbd", 16))), "jiao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fbe", 16))), "ju");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fbf", 16))), "jia");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc0", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc1", 16))), "hong");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc2", 16))), "niao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc3", 16))), "shan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc4", 16))), "liang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc5", 16))), "ling");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc6", 16))), "fu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc7", 16))), "zheng");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc8", 16))), "che");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fc9", 16))), "wu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fca", 16))), "zhi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fcb", 16))), "xi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fcc", 16))), "liang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fcd", 16))), "gang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fce", 16))), "da");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fcf", 16))), "mai");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd0", 16))), "jiu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd1", 16))), "jue");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd2", 16))), "ye");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd3", 16))), "ye");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd4", 16))), "ge");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd5", 16))), "dan");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd6", 16))), "he");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd7", 16))), "yi");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd8", 16))), "he");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fd9", 16))), "ke");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fda", 16))), "ge");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fdb", 16))), "ling");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fdc", 16))), "la");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fdd", 16))), "leng");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fde", 16))), "lie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fdf", 16))), "li");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe0", 16))), "li");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe1", 16))), "luo");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe2", 16))), "he");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe3", 16))), "ke");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe4", 16))), "ge");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe5", 16))), "lang");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe6", 16))), "ying");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe7", 16))), "long");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe8", 16))), "lei");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fe9", 16))), "lu");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fea", 16))), "sui");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9feb", 16))), "ao");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fec", 16))), "tian");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fed", 16))), "nie");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fee", 16))), "dai");
		mStrToPinYinMap.put(String.valueOf(Character.toChars(Integer.parseInt("9fef", 16))), "li");
	}

	// init Pinyin Output Format
	private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

	/**
	 * Convert from base data to a series of PinyinUnit
	 * 
	 * @param pinyinSearchUnit
	 */
	public static void parse(PinyinSearchUnit pinyinSearchUnit) {
		if ((null==pinyinSearchUnit)||(CommonUtil.isEmpty(pinyinSearchUnit.getBaseData()))||(null==pinyinSearchUnit.getPinyinUnits())) {
			return;
		}

		String chineseStr = pinyinSearchUnit.getBaseData().toLowerCase();

		if (null == format) {
			format = new HanyuPinyinOutputFormat();
		}

		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		int cpNum = chineseStr.codePointCount(0, chineseStr.length());
		StringBuffer nonPinyinString = new StringBuffer();
		PinyinUnit pyUnit = null;
		String originalString = null;
		String[] pinyinStr = null;
		boolean lastChineseCharacters = true;
		int startPosition = -1;

		for (int i = 0; i < cpNum; i++) {
			int codepointIndex = chineseStr.offsetByCodePoints(0, i);
			int codepoint = chineseStr.codePointAt(codepointIndex);
			char[] chars = Character.toChars(codepoint);
			String letter = String.valueOf(chars);
			if (mStrToPinYinMap.get(letter) != null) { // 生僻字
				pinyinStr = new String[]{mStrToPinYinMap.get(letter)};
				originalString = letter;
			} else {
				char ch = chineseStr.charAt(codepointIndex);
				originalString = String.valueOf(ch);
				try {
					pinyinStr = PinyinHelper.toHanyuPinyinStringArray(ch, format);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			}

			if (null == pinyinStr) {
				if (true == lastChineseCharacters) {
					pyUnit = new PinyinUnit();
					lastChineseCharacters = false;
					startPosition = codepointIndex;
					nonPinyinString.delete(0, nonPinyinString.length());
				}
				nonPinyinString.append(originalString);
			} else {
				if (false == lastChineseCharacters) {
					// add continuous non-ChineseCharacter characters to PinyinUnit
					originalString = nonPinyinString.toString();
					String[] str = { nonPinyinString.toString() };
					addPinyinUnit(pinyinSearchUnit.getPinyinUnits(), pyUnit, false, originalString,str, startPosition);
					nonPinyinString.delete(0, nonPinyinString.length());
					lastChineseCharacters = true;
				}
				// add single Chinese characters Pinyin(include Multiple Pinyin)
				// to PinyinUnit
				pyUnit = new PinyinUnit();
				startPosition = codepointIndex;
				addPinyinUnit(pinyinSearchUnit.getPinyinUnits(), pyUnit, true, originalString,pinyinStr, startPosition);
			}
		}

		if (false == lastChineseCharacters) {
			// add continuous non-ChineseCharacter characters to PinyinUnit
			originalString = nonPinyinString.toString();
			String[] str = { nonPinyinString.toString() };
			addPinyinUnit(pinyinSearchUnit.getPinyinUnits(), pyUnit, false, originalString, str,startPosition);
			nonPinyinString.delete(0, nonPinyinString.length());
			lastChineseCharacters = true;
		}

	}

	/**
	 * get the first letter from original string
	 * 
	 * @param pinyinSearchUnit
	 * @return return the first letter of original string,otherwise return null.
	 */
	public static String getFirstLetter(PinyinSearchUnit pinyinSearchUnit) {
		do {
			if(null==pinyinSearchUnit){
				break;
			}
			
			List<PinyinUnit> pinyinUnit=pinyinSearchUnit.getPinyinUnits();
			if (null == pinyinUnit || pinyinUnit.size() <= 0) {
				break;
			}

			List<PinyinBaseUnit> pinyinBaseUnit = pinyinUnit.get(0).getPinyinBaseUnitIndex();
			if (null == pinyinBaseUnit || pinyinBaseUnit.size() <= 0) {
				break;
			}

			String pinyin = pinyinBaseUnit.get(0).getPinyin();
			if (null == pinyin || pinyin.length() <= 0) {
				break;
			}

			return String.valueOf(pinyin.charAt(0));

		} while (false);

		return null;
	}


	/**
	 * get the first character from original string
	 * 
	 * @param pinyinSearchUnit
	 * @return return the first character of original string,otherwise return null.
	 */
	public static String getFirstCharacter(PinyinSearchUnit pinyinSearchUnit) {
		
		
		do {
			if(null==pinyinSearchUnit){
				break;
			}
			
			List<PinyinUnit> pinyinUnit=pinyinSearchUnit.getPinyinUnits();
			if (null == pinyinUnit || pinyinUnit.size() <= 0) {
				break;
			}

			List<PinyinBaseUnit> pinyinBaseUnit = pinyinUnit.get(0).getPinyinBaseUnitIndex();
			if (null == pinyinBaseUnit || pinyinBaseUnit.size() <= 0) {
				break;
			}

			String originalString = pinyinBaseUnit.get(0).getOriginalString();
			if (null == originalString || originalString.length() <= 0) {
				break;
			}

			return String.valueOf(originalString.charAt(0));

		} while (false);

		return null;
	}
	
	/**
	 * get sort key, as sort keyword
	 * 
	 * @param pinyinSearchUnit
	 * @return return sort key,otherwise return null.
	 */
	public static String getSortKey(PinyinSearchUnit pinyinSearchUnit) {
		StringBuffer sortKeyBuffer=new StringBuffer();
		sortKeyBuffer.delete(0, sortKeyBuffer.length());
		String splitSymbol=" ";
		do {
			if(null==pinyinSearchUnit){
				break;
			}
			List<PinyinUnit> pinyinUnit=pinyinSearchUnit.getPinyinUnits();
			if ((null == pinyinUnit) || (pinyinUnit.size() <= 0)) {
				break;
			}
			
			for(PinyinUnit pu:pinyinUnit){
				if(pu.isPinyin()){
					sortKeyBuffer.append(pu.getPinyinBaseUnitIndex().get(0).getPinyin()).append(splitSymbol);
					sortKeyBuffer.append(pu.getPinyinBaseUnitIndex().get(0).getOriginalString()).append(splitSymbol);
				}else{
					sortKeyBuffer.append(pu.getPinyinBaseUnitIndex().get(0).getOriginalString()).append(splitSymbol);
				}
			}
			
			return sortKeyBuffer.toString();
		} while (false);

		return null;
	}

	/**
	 * judge chr is Chinese Character
	 *
	 * @param chr
	 * @return Is Chinese Character return true,otherwise return false.
	 */
	public static boolean isChineseCharacter(char chr){
		String[] pinyinStr = null;
		try {
			pinyinStr = PinyinHelper.toHanyuPinyinStringArray(chr, format);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}

		return (null==pinyinStr)?(false):(true);
	}

	private static void addPinyinUnit(List<PinyinUnit> pinyinUnit,PinyinUnit pyUnit, boolean pinyin, String originalString,String[] string, int startPosition) {
		if ((null == pinyinUnit) || (null == pyUnit)
				|| (null == originalString) || (null == string)) {
			return;
		}

		initPinyinUnit(pyUnit, pinyin, originalString, string, startPosition);
		pinyinUnit.add(pyUnit);

		return;

	}

	private static void initPinyinUnit(PinyinUnit pinyinUnit, boolean pinyin,String originalString, String[] string, int startPosition) {
		if ((null == pinyinUnit) || (null == originalString)
				|| (null == string)) {
			return;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		int strLength = string.length;
		pinyinUnit.setPinyin(pinyin);
		pinyinUnit.setStartPosition(startPosition);

		PinyinBaseUnit pinyinBaseUnit = null;

		if (false == pinyin || strLength <= 1) {// no more than one pinyin
			for (i = 0; i < strLength; i++) {
				pinyinBaseUnit = new PinyinBaseUnit();
				initPinyinBaseUnit(pinyinBaseUnit, originalString, string[i]);
				pinyinUnit.getPinyinBaseUnitIndex().add(pinyinBaseUnit);
			}
		} else { // more than one pinyin.//we must delete the same pinyin
					// string,because pinyin without tone.

			pinyinBaseUnit = new PinyinBaseUnit();
			initPinyinBaseUnit(pinyinBaseUnit, originalString, string[0]);
			pinyinUnit.getPinyinBaseUnitIndex().add(pinyinBaseUnit);
			for (j = 1; j < strLength; j++) {
				int curStringIndexlength = pinyinUnit.getPinyinBaseUnitIndex().size();
				for (k = 0; k < curStringIndexlength; k++) {
					if (pinyinUnit.getPinyinBaseUnitIndex().get(k).getPinyin().equals(string[j])) {
						break;
					}
				}

				if (k == curStringIndexlength) {
					pinyinBaseUnit = new PinyinBaseUnit();
					initPinyinBaseUnit(pinyinBaseUnit, originalString, string[j]);
					pinyinUnit.getPinyinBaseUnitIndex().add(pinyinBaseUnit);
				}
			}
		}
	}

	private static void initPinyinBaseUnit(PinyinBaseUnit pinyinBaseUnit,String originalString, String pinyin) {
		if ((null == pinyinBaseUnit) || (null == originalString)
				|| (null == pinyin)) {
			return;
		}

		pinyinBaseUnit.setOriginalString(new String(originalString));
		pinyinBaseUnit.setPinyin(new String(pinyin));
		int pinyinLength = pinyin.length();
		StringBuffer numBuffer = new StringBuffer();
		numBuffer.delete(0, numBuffer.length());

		for (int i = 0; i < pinyinLength; i++) {
			char ch = T9Util.getT9Number(pinyin.charAt(i));
			numBuffer.append(ch);
		}

		pinyinBaseUnit.setNumber(new String(numBuffer.toString()));
		numBuffer.delete(0, numBuffer.length());

		return;
	}
}
