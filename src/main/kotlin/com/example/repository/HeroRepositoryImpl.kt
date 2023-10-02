package com.example.repository

import com.example.model.ApiResponse
import com.example.model.Hero
import com.example.repository.constant.ConstantRepo

class HeroRepositoryImpl : HeroRepository {

    override val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }
    override val page1: List<Hero> = listOf(
        Hero(
            id = 1,
            name = "Amado Sanzu",
            image = "/images/amado.jpg",
            about = "Amado Sanzu (三途アマド, Sanzu Amado) adalah mantan Inner dari organisasi Kara dan merupakan kepala divisi penelitian dan pengembangannya. Dia telah membelot ke Konohagakure, di mana dia menggunakan campuran gertakan dan hadiah untuk mendapatkan kewarganegaraan resmi untuk perlindungan Hokage Ketujuh.",
            rating = 2.0,
            power = 50,
            month = "Agustus",
            day = "12",
            family = listOf("Akebi Anzu (Anak)"),
            abilities = listOf("Intelektual Hebat", "Pengembangan Shinobi-ware"),
            natureTypes = listOf("Kepintaran", "Analisis")
        ),
        Hero(
            id = 2,
            name = "Uzumaki Boruto",
            image = "/images/boruto.png",
            about = "Boruto Uzumaki (うずまきボルト, Uzumaki Boruto) adalah ninja hilang dari klan Uzumaki Konohagakure dan keturunan langsung dari klan Hyuga melalui ibunya. Meskipun awalnya membenci ayahnya dan ketidakhadirannya sejak menjadi Hokage, Boruto akhirnya datang untuk menghormati ayah dan tugasnya. Terlepas dari itu, ia bersumpah untuk menjadi shinobi seperti mentornya, Sasuke Uchiha. Dia kemudian dipaksa untuk membelot dari desa bersama Sasuke setelah dia dituduh membunuh Naruto dan istrinya oleh Kawaki setelah Kemahakuasaan Ada.",
            rating = 5.0,
            power = 95,
            month = "Maret",
            day = "27",
            family = listOf(
                "Minato Namikaze (Kakek)",
                "Kushina Uzumaki (nenek)",
                "Naruto Uzumaki (Ayah)",
                "Penatua Hyuga (Kakek Buyut)",
                "Hiashi Hyuga (Kakek)",
                "Hizashi Hyuga (Kakek)",
                "Ibu Hinata dan Hanabi (Nenek) (Hanya di Anime)",
                "Hinata Hyuga (Ibu)",
                "Hanabi Hyuga (Bibi)",
                "Himawari Uzumaki (saudara perempuan)",
                "Neji Hyuga (Sepupu pertama setelah disingkirkan)",
                "Kawaki (Kakak angkat)",
                "Momoshiki Ōtsutsuki (Pembawa Acara)"
            ),
            abilities = listOf(
                "Chakra dan Kecakapan Fisik",
                "Ninjutsu",
                "Bukijutsu",
                "Transformasi Alam",
                "Kāma",
                "Dōjutsu",
                "Mata Jōgan",
                "Intelijen"
            ),
            natureTypes = listOf("Kama", "Intelejen")
        ),
        Hero(
            id = 3,
            name = "Code",
            image = "/images/code.jpg",
            about = "Pada saat Kawaki dibawa ke Kara, Code adalah salah satu dari lima belas kandidat yang dipilih untuk berpartisipasi dalam ritual Ōtsutsuki Jigen dan Amado Sanzu untuk menyaring wadah Kāma untuk Isshiki. Hanya Kawaki yang selamat untuk menjadi kapal yang sebenarnya. Code, di sisi lain, menunjukkan gemetar dan kejang seperti kandidat yang gagal dan meninggal, tetapi berhasil bertahan di mana tanda mereknya menjadi Kāma Putih.",
            rating = 4.8,
            power = 98,
            month = "Desember",
            day = "22",
            family = listOf("Tidak diketahui"),
            abilities = listOf("Memodifikasi Tubuh", "Kama", "Busur Aktuasi Kara", "Busur Ao", "Busur Kawaki", "Busur Serangan Kode", "Busur Kemahakuasaan"),
            natureTypes = listOf("Ambisi yang kuat")
        ),
    )
    override val page2: List<Hero> = listOf(
        Hero(
            id = 4,
            name = "Uchiha Sasuke",
            image = "/images/sasuke.jpg",
            about = "Sasuke Uchiha (うちはサスケ, Uchiha Sasuke) is one of the last surviving members of Konohagakure's Uchiha clan. After his older brother, Itachi, slaughtered their clan, Sasuke made it his mission in life to avenge them by killing Itachi. He is added to Team 7 upon becoming a ninja and, through competition with his rival and best friend, Naruto Uzumaki.",
            rating = 5.0,
            power = 98,
            month = "July",
            day = "23rd",
            family = listOf(
                "Fugaku",
                "Mikoto",
                "Itachi",
                "Sarada",
                "Sakura"
            ),
            abilities = listOf(
                "Sharingan",
                "Rinnegan",
                "Sussano",
                "Amateratsu",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Fire",
                "Wind",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 5,
            name = "Naruto Uzumaki",
            image = "/images/naruto.jpg",
            about = "Naruto Uzumaki (うずまきナルト, Uzumaki Naruto) is a shinobi of Konohagakure's Uzumaki clan. He became the jinchūriki of the Nine-Tails on the day of his birth — a fate that caused him to be shunned by most of Konoha throughout his childhood. After joining Team Kakashi, Naruto worked hard to gain the village's acknowledgement all the while chasing his dream to become Hokage.",
            rating = 5.0,
            power = 98,
            month = "Oct",
            day = "10th",
            family = listOf(
                "Minato",
                "Kushina",
                "Boruto",
                "Himawari",
                "Hinata"
            ),
            abilities = listOf(
                "Rasengan",
                "Rasen-Shuriken",
                "Shadow Clone",
                "Senin Mode"
            ),
            natureTypes = listOf(
                "Wind",
                "Earth",
                "Lava",
                "Fire"
            )
        ),
        Hero(
            id = 6,
            name = "Uchiha Sakura",
            image = "/images/sakura.jpg",
            about = "Sakura Uchiha (うちはサクラ, Uchiha Sakura, née Haruno (春野)) is a kunoichi of Konohagakure. When assigned to Team 7, Sakura quickly finds herself ill-prepared for the duties of a shinobi. However, after training under the Sannin Tsunade, she overcomes this, and becomes recognised as one of the greatest medical-nin in the world.",
            rating = 4.5,
            power = 92,
            month = "Mar",
            day = "28th",
            family = listOf(
                "Kizashi",
                "Mebuki",
                "Sarada",
                "Sasuke"
            ),
            abilities = listOf(
                "Chakra Control",
                "Medical Ninjutsu",
                "Strength",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Earth",
                "Water",
                "Fire"
            )
        )
    )
    override val page3: List<Hero> = listOf(
        Hero(
            id = 7,
            name = "Uchiha Sarada",
            image = "/images/sarada.jpg",
            about = "Sarada Uchiha (うちはサラダ, Uchiha Sarada) is a kunoichi from Konohagakure's Uchiha clan. Because she was raised only by her mother without having her father around, Sarada initially struggles to understand who she is or what she's supposed to be. After meeting him with the help of Naruto Uzumaki, Sarada comes to believe that she is defined by the connections she has with others, and as a member of Team Konohamaru, she seeks to someday become Hokage so that she can connect with as many people as possible.",
            rating = 4.9,
            power = 95,
            month = "Mar",
            day = "31st",
            family = listOf(
                "Sasuke Uchiha",
                "Sakura Uchiha"
            ),
            abilities = listOf(
                "Sharingan",
                "Strength",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire"
            )
        ),
        Hero(
            id = 8,
            name = "Mitsuki",
            image = "/images/mitsuki.jpg",
            about = "Mitsuki (ミツキ, Mitsuki) is a synthetic human that was created as a partial clone of Orochimaru. Immigrating to Konohagakure to confirm whether or not Boruto Uzumaki was his \"sun\", he became a shinobi and was placed on Team Konohamaru. Mitsuki was created as a clone of Orochimaru, being cultivated from the same embryo as at least one older \"Mitsuki\", and raised in a test tube.",
            rating = 4.9,
            power = 95,
            month = "Jul",
            day = "25th",
            family = listOf(
                "Orochimaru",
                "Log"
            ),
            abilities = listOf(
                "Senin Mode",
                "Transformation",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind"
            )
        ),
        Hero(
            id = 9,
            name = "Kawaki",
            image = "/images/kawaki.jpg",
            about = "Kawaki (カワキ, Kawaki) is a child raised by Kara to be the future vessel for Isshiki Ōtsutsuki and the key to the fulfilment of their greatest wish.[1] After being brought to Konohagakure by Team 7, he is taken in by Naruto Uzumaki who raises him as his own, during which he develops a brotherly bond with Boruto Uzumaki to solve the mystery of the Kāma.",
            rating = 4.2,
            power = 92,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Kokatsu"
            ),
            abilities = listOf(
                "Karma",
                "Transformation",
                "Strength"
            ),
            natureTypes = listOf(
                "Fire"
            )
        )
    )
    override val page4: List<Hero> = listOf(
        Hero(
            id = 10,
            name = "Orochimaru",
            image = "/images/orochimaru.jpg",
            about = "Orochimaru (大蛇丸, Orochimaru) is one of Konohagakure's legendary Sannin. With a life-ambition to learn all of the world's secrets, Orochimaru seeks immortality so that he might live all of the lives necessary to accomplish his task. After being caught red-handed performing unethical experiments on his fellow citizens for the sake of this immortality, Orochimaru defected from Konoha.",
            rating = 4.5,
            power = 97,
            month = "Oct",
            day = "27th",
            family = listOf(
                "Mitsuki",
                "Log"
            ),
            abilities = listOf(
                "Senin Mode",
                "Transformation",
                "Science"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 11,
            name = "Hatake Kakashi",
            image = "/images/kakashi.png",
            about = "Kakashi Hatake (はたけカカシ, Hatake Kakashi) is a shinobi of Konohagakure's Hatake clan. Famed as Kakashi of the Sharingan (写輪眼のカカシ, Sharingan no Kakashi), he is one of Konoha's most talented ninja, regularly looked to for advice and leadership despite his personal dislike of responsibility. To his students on Team 7, Kakashi emphasises the importance of teamwork; he himself received this lesson, along with the Sharingan, from his childhood friend, Obito Uchiha.",
            rating = 4.5,
            power = 96,
            month = "Sep",
            day = "15th",
            family = listOf(
                "Sakumo"
            ),
            abilities = listOf(
                "Intelligence",
                "Strength"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 12,
            name = "Isshiki",
            image = "/images/ishiki.jpg",
            about = "A thousand years ago, Isshiki came to Earth alongside Kaguya with the objective to plant a Tree to harvest its Chakra Fruit. While Kaguya, being lower-ranked, was planned to be sacrificed to create the Chakra Fruit, she instead turned on Isshiki, leaving him on the verge of death after destroying Isshiki's lower half. Encountering Jigen and not having the strength to implant a Kāma on him, Isshiki devised a desperate plan and shrunk himself to enter the monk's ear in order to survive his injury by absorbing Jigen's nutrients.",
            rating = 5.0,
            power = 100,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Sukunahikona",
                "Daikokuten",
                "Byakugan",
                "Space–Time",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Fire"
            )
        )
    )
    override val page5: List<Hero> = listOf(
        Hero(
            id = 13,
            name = "Momoshiki",
            image = "/images/momoshiki.jpg",
            about = "Momoshiki Ōtsutsuki (大筒木モモシキ, Ōtsutsuki Momoshiki) was a member of the Ōtsutsuki clan's main family, sent to investigate the whereabouts of Kaguya and her God Tree and then attempting to cultivate a new one out of the chakra of the Seventh Hokage. In the process of being killed by Boruto Uzumaki, Momoshiki placed a Kāma on him, allowing his spirit to remain intact through the mark.",
            rating = 3.9,
            power = 98,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Rinnegan",
                "Byakugan",
                "Strength"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Water",
                "Earth"
            )
        ),
        Hero(
            id = 14,
            name = "Urashiki Ōtsutsuki",
            image = "/images/urashiki.jpg",
            about = "Urashiki Ōtsutsuki (大筒木ウラシキ, Ōtsutsuki Urashiki) was a low-ranking member of the Ōtsutsuki clan's main family, sent to assist Momoshiki and Kinshiki on their mission to investigate Kaguya's whereabouts and gather the chakra of the God Tree on Earth. Compared to his comrades, Urashiki had been shown to have a rather laid-back and jovial personality. He was quite willing to joke along with Momoshiki and Kinshiki, and disparaged on how serious they are.",
            rating = 3.4,
            power = 95,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Space–Time",
                "Rinnegan",
                "Byakugan"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Earth"
            )
        ),
        Hero(
            id = 15,
            name = "Koji",
            image = "/images/koji.jpg",
            about = "Koji Kashin (果心居士, Kashin Koji) is a clone of Jiraiya that was created by Amado for the purpose of killing Isshiki Ōtsutsuki. A former Inner of Kara, he was in charge of the sector on the outskirts of the Land of Fire. An enigmatic man, Koji has a very stoic and straightforward nature that follows a no-nonsense view. Arrogant as he may appear, he has consistently shown himself to be a very rational and perceptive man.",
            rating = 4.5,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Jiraiya"
            ),
            abilities = listOf(
                "Senin Mode",
                "Rasengan",
                "Shadow Clone"
            ),
            natureTypes = listOf(
                "Fire",
                "Earth"
            )
        )
    )
    override suspend fun getAllHeroes(page: Int): ApiResponse = ApiResponse(
        success = true,
        message = "Ok",
        prevPage = calculatePage(page)[ConstantRepo.PREVIOUS_PAGE_KEY],
        nextPage = calculatePage(page)[ConstantRepo.NEXT_PAGE_KEY],
        heroes = heroes[page] ?: emptyList(),
        lastUpdated = System.currentTimeMillis()
    )

    private fun calculatePage(page: Int) : Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page

        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }

        return mapOf("prevPage" to prevPage, "nextPage" to nextPage)
    }
    override suspend fun searchHeroes(name: String?): ApiResponse = ApiResponse(
        success = true,
        message = "Ok",
        heroes = findHeroes(name)
    )

    private fun findHeroes(query: String?) : List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (!query.isNullOrEmpty()) {
            heroes.forEach { (_, heroes) ->
                heroes.forEach { hero ->
                    if (hero.name.lowercase().contains(query.lowercase())) {
                        founded.add(hero)
                    }
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}