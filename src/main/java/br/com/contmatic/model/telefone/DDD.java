package br.com.contmatic.model.telefone;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum DDD {

	DDD11("Região Metropolitana de São Paulo", 11),

	DDD12("São José dos Campos e Região", 12),

	DDD13("Região Metropolitana da Baixada Santista", 13),

	DDD14("Bauru, Jaú, Marília, Botucatu e Região", 14),

	DDD15("Sorocaba e Região", 15),

	DDD16("Ribeirão Preto, São Carlos, Araraquara e Região", 16),

	DDD17("São José do Rio Preto e Região", 17),

	DDD18("Presidente Prudente, Araçatuba e Região", 18),

	DDD19("Região Metropolitana de Campinas", 19),

	DDD22("Campos dos Goytacazes e Região", 22),

	DDD21("Região Metropolitana do Rio de Janeiro", 21),

	DDD24("Volta Redonda, Petrópolis e Região", 24),

	DDD27("Região Metropolitana de Vitória", 27),

	DDD28("Cachoeiro de Itapemirim e Região", 28),

	DDD31("Região Metropolitana de Belo Horizonte", 31),

	DDD32("Juiz de Fora e Região", 32),

	DDD33("Governador Valadares e Região", 33),

	DDD34("Uberlândia e região", 34),

	DDD35("Poços de Caldas, Pouso Alegre, Varginha e Região", 34),

	DDD37("Divinópolis, Itaúna e Região", 37),

	DDD38("Montes Claros e Região", 38),

	DDD41("Região Metropolitana de Curitiba", 41),

	DDD42("Ponta Grossa e Região", 42),

	DDD43("Londrina e Região", 43),

	DDD44("Maringá e Região", 44),

	DDD45("Cascavel e Região", 45),

	DDD46("Francisco Beltrão, Pato Branco e Região", 46),

	DDD47("Joinville, Blumenau, Balneário Camboriú e Região", 47),

	DDD48("Região Metropolitana de Florianópolis e Criciúma", 48),

	DDD49("Chapecó, Lages e Região", 49),

	DDD51("Região Metropolitana de Porto Alegre", 51),

	DDD53("Pelotas e Região", 53),

	DDD54("Caxias do Sul e Região", 54),

	DDD55("Santa Maria e Região", 55),

	DDD61("Brasília e Região", 61),

	DDD62("Região Metropolitana de Goiânia", 62),

	DDD63("Tocantins", 63),

	DDD64("Rio Verde e Região", 64),

	DDD65("Região Metropolitana de Cuiabá", 65),

	DDD67("Mato Grosso do Sul", 67),

	DDD68("Acre", 68),

	DDD69("Rondônia", 69),

	DDD71("Região Metropolitana de Salvador", 71),

	DDD73("Itabuna, Ilhéus e Região", 73),

	DDD74("Juazeiro e Região", 74),

	DDD75("Feira de Santana e Região", 75),

	DDD77("Vitória da Conquista e Região", 77),

	DDD79("Sergipe", 79),

	DDD81("Região Metropolitana de Recife", 81),

	DDD82("Alagoas", 82),

	DDD83("Paraíba ", 83),

	DDD84("Rio Grande do Norte", 84),

	DDD85("Região Metropolitana de Fortaleza", 85),

	DDD88("Região de Juazeiro do Norte", 88),

	DDD86("Região de Teresina", 86),

	DDD89("Região de Picos e Floriano", 89),

	DDD87("Região de Petrolina", 87),

	DDD91("Região Metropolitana de Belém", 91),

	DDD93("Região de Santarém", 93),

	DDD94("Região de Marabá", 94),

	DDD92("Região de Manaus", 92),

	DDD97("Região de Tefé e Coari", 97),

	DDD95("Todos os municípios do estado", 95),

	DDD96("Todos os municípios do estado", 96),

	DDD98("Região Metropolitana de São Luís", 98),

	DDD99("Região de Imperatriz", 99);

	private String regiao;

	private int numero;

	DDD(String regiao, int ddd) {

		this.regiao = regiao;
		this.numero = ddd;
	}

	public String getRegiao() {
		return regiao;
	}

	public int getDdd() {
		return numero;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}
}
