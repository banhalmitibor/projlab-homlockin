SRC_DIR = src
OUT_DIR = out
MAIN_CLASS = homlockin.Main

SOURCES = $(wildcard $(SRC_DIR)/homlockin/*.java)

.PHONY: all clean run

all: $(OUT_DIR)
	javac -d $(OUT_DIR) $(SOURCES)

$(OUT_DIR):
	mkdir -p $(OUT_DIR)

run: all
	java -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)
