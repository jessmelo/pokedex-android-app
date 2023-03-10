package com.jessmelo.apps.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonInfo(
    @SerializedName("abilities")
    var abilities: List<Ability>? = listOf(),
    @SerializedName("base_experience")
    var baseExperience: Int? = 0,
    @SerializedName("forms")
    var forms: List<Form>? = listOf(),
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice>? = listOf(),
    @SerializedName("height")
    var height: Int? = 0,
    @SerializedName("held_items")
    var heldItems: List<HeldItem>? = listOf(),
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("is_default")
    var isDefault: Boolean? = false,
    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String? = "",
    @SerializedName("moves")
    var moves: List<Move>? = listOf(),
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("order")
    var order: Int? = 0,
    @SerializedName("past_types")
    var pastTypes: List<Any>? = listOf(),
    @SerializedName("species")
    var species: Species? = Species(),
    @SerializedName("sprites")
    var sprites: Sprites? = Sprites(),
    @SerializedName("stats")
    var stats: List<Stat>? = listOf(),
    @SerializedName("types")
    var types: List<Type>? = listOf(),
    @SerializedName("weight")
    var weight: Int? = 0
)

data class Ability(
    @SerializedName("ability")
    var ability: AbilityX? = AbilityX(),
    @SerializedName("is_hidden")
    var isHidden: Boolean? = false,
    @SerializedName("slot")
    var slot: Int? = 0
)

data class Form(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int? = null,
    @SerializedName("version")
    var version: Version? = null
)

data class HeldItem(
    @SerializedName("item")
    var item: Item? = Item(),
    @SerializedName("version_details")
    var versionDetails: List<VersionDetail>? = listOf()
)

data class Move(
    @SerializedName("move")
    var move: MoveX? = MoveX(),
    @SerializedName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail>? = listOf()
)

data class Species(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class Sprites(
    @SerializedName("back_default")
    var backDefault: String? = "",
    @SerializedName("back_female")
    var backFemale: Any? = Any(),
    @SerializedName("back_shiny")
    var backShiny: String? = "",
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any? = Any(),
    @SerializedName("front_default")
    var frontDefault: String? = "",
    @SerializedName("front_female")
    var frontFemale: Any? = Any(),
    @SerializedName("front_shiny")
    var frontShiny: String? = "",
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = Any(),
    @SerializedName("other")
    var other: Other? = Other(),
    @SerializedName("versions")
    var versions: Versions? = Versions()
)

data class Stat(
    @SerializedName("base_stat")
    var baseStat: Int? = 0,
    @SerializedName("effort")
    var effort: Int? = 0,
    @SerializedName("stat")
    var stat: StatX? = StatX()
)

data class Type(
    @SerializedName("slot")
    var slot: Int? = 0,
    @SerializedName("type")
    var type: TypeX? = TypeX()
)

data class AbilityX(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class Version(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class Item(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class VersionDetail(
    @SerializedName("rarity")
    var rarity: Int? = 0,
    @SerializedName("version")
    var version: Version? = Version()
)

data class MoveX(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    var levelLearnedAt: Int? = null,
    @SerializedName("move_learn_method")
    var moveLearnMethod: MoveLearnMethod? = null,
    @SerializedName("version_group")
    var versionGroup: VersionGroup? = null
)

data class MoveLearnMethod(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class VersionGroup(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class Other(
    @SerializedName("dream_world")
    var dreamWorld: DreamWorld? = null,
    @SerializedName("home")
    var home: Home? = null,
    @SerializedName("official-artwork")
    var officialArtwork: OfficialArtwork? = null
)

data class Versions(
    @SerializedName("generation-i")
    var generationI: GenerationI? = GenerationI(),
    @SerializedName("generation-ii")
    var generationIi: GenerationIi? = GenerationIi(),
    @SerializedName("generation-iii")
    var generationIii: GenerationIii? = GenerationIii(),
    @SerializedName("generation-iv")
    var generationIv: GenerationIv? = GenerationIv(),
    @SerializedName("generation-v")
    var generationV: GenerationV? = GenerationV(),
    @SerializedName("generation-vi")
    var generationVi: GenerationVi? = GenerationVi(),
    @SerializedName("generation-vii")
    var generationVii: GenerationVii? = GenerationVii(),
    @SerializedName("generation-viii")
    var generationViii: GenerationViii? = GenerationViii()
)

data class DreamWorld(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null
)

data class Home(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class OfficialArtwork(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null
)

data class GenerationI(
    @SerializedName("red-blue")
    var redBlue: RedBlue? = null,
    @SerializedName("yellow")
    var yellow: Yellow? = null
)

data class GenerationIi(
    @SerializedName("crystal")
    var crystal: Crystal? = null,
    @SerializedName("gold")
    var gold: Gold? = null,
    @SerializedName("silver")
    var silver: Silver? = null
)

data class GenerationIii(
    @SerializedName("emerald")
    var emerald: Emerald? = null,
    @SerializedName("firered-leafgreen")
    var fireredLeafgreen: FireredLeafgreen? = null,
    @SerializedName("ruby-sapphire")
    var rubySapphire: RubySapphire? = null
)

data class GenerationIv(
    @SerializedName("diamond-pearl")
    var diamondPearl: DiamondPearl? = null,
    @SerializedName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver? = null,
    @SerializedName("platinum")
    var platinum: Platinum? = null
)

data class GenerationV(
    @SerializedName("black-white")
    var blackWhite: BlackWhite? = null
)

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,
    @SerializedName("x-y")
    var xY: XY? = null
)

data class GenerationVii(
    @SerializedName("icons")
    var icons: Icons? = null,
    @SerializedName("ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon? = null
)

data class GenerationViii(
    @SerializedName("icons")
    var icons: Icons? = Icons()
)

data class RedBlue(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_gray")
    var backGray: String? = null,
    @SerializedName("back_transparent")
    var backTransparent: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_gray")
    var frontGray: String? = null,
    @SerializedName("front_transparent")
    var frontTransparent: String? = null
)

data class Yellow(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_gray")
    var backGray: String? = null,
    @SerializedName("back_transparent")
    var backTransparent: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_gray")
    var frontGray: String? = null,
    @SerializedName("front_transparent")
    var frontTransparent: String? = null
)

data class Crystal(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("back_shiny_transparent")
    var backShinyTransparent: String? = null,
    @SerializedName("back_transparent")
    var backTransparent: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_transparent")
    var frontShinyTransparent: String? = null,
    @SerializedName("front_transparent")
    var frontTransparent: String? = null
)

data class Gold(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_transparent")
    var frontTransparent: String? = null
)

data class Silver(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_transparent")
    var frontTransparent: String? = null
)

data class Emerald(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null
)

data class FireredLeafgreen(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null
)

data class RubySapphire(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null
)

data class DiamondPearl(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_female")
    var backFemale: Any? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class HeartgoldSoulsilver(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_female")
    var backFemale: Any? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class Platinum(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_female")
    var backFemale: Any? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class BlackWhite(
    @SerializedName("animated")
    var animated: Animated? = null,
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_female")
    var backFemale: Any? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class Animated(
    @SerializedName("back_default")
    var backDefault: String? = null,
    @SerializedName("back_female")
    var backFemale: Any? = null,
    @SerializedName("back_shiny")
    var backShiny: String? = null,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any? = null,
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class OmegarubyAlphasapphire(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class XY(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class Icons(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null
)

data class UltraSunUltraMoon(
    @SerializedName("front_default")
    var frontDefault: String? = null,
    @SerializedName("front_female")
    var frontFemale: Any? = null,
    @SerializedName("front_shiny")
    var frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any? = null
)

data class StatX(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)

data class TypeX(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)