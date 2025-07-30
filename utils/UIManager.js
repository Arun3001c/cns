import { bgSoundManager } from "./BGSoundManager.js"


class UIManager {
    
    level1 = true
    level2 = false
    level3 = false
    level4 = false
    level5 = false
    level6 = false

    displayLivesCount(player) {
        this.livesCountUI = add([
            text("", {
                font: "Round",
                size: 50
            }),
            fixed(),
            pos(70,10)
        ])
        this.livesCountUI.add([
            sprite("star-icon"),
            pos(-60, -5),
            scale(3),
            fixed()
        ])
    }

    displayCoinCount(player) {
        this.coinCountUI = add([
            text("", {
                font:"Round",
                size:50
            }),
            {
                fullCoinCount: get("coin", { recursive: true }).length
            },
            fixed(),
            pos(70, 70)
        ])

        this.coinCountUI.add([
            sprite("coin-icon"),
            pos(-60, 0),
            scale(3),
            fixed()
        ])
    }

    displayBlinkingUIMessage(content, position) {
        const message = add([
            text(content, {
                size: 24,
                font: "Round"
            }),
            area(),
            anchor("center"),
            pos(position),
            opacity(),
            state("flash-up", ["flash-up", "flash-down"])
        ])

        message.onStateEnter("flash-up", async() => {
            await tween(
                message.opacity,
                0,
                0.5,
                (nextOpacityValue) => message.opacity = nextOpacityValue,
                easings.linear
            )
            message.enterState("flash-down")
        })

        message.onStateEnter("flash-down", async() => {
            await tween(
                message.opacity,
                1,
                0.5,
                (nextOpacityValue) => message.opacity = nextOpacityValue,
                easings.linear
            )
            message.enterState("flash-up")
        })
    }   

    displayMainMenu() {
        add([
            sprite("forest-background"),

        ])
        add([
            sprite("logo"),
            area(),
            anchor("center"),
            pos(center().x, center().y - 200),
            scale(8)
        ])

        this.displayBlinkingUIMessage(
            "Press [ Enter ] to Start Game",
            vec2(center().x, center().y + 100)
        )

        onKeyPress("enter", () => {
            play("confirm-ui", { speed: 1.5 })
            go("controls")
        })
    }

    displayLevelMenu() {
        add([
            sprite("forest-background"),

        ])
        add([
            text("Select a Level",{ font: "Round", size: 50 }),
            anchor("center"),
            pos(center().x, center().y - 200),
            scale(2),
        ]);

        add([
            sprite("level1"),
            area(),
            anchor("center"),
            pos(300, 300),
            scale(0.5),
            "level1"
        ])
        add([
            sprite("level2"),
            area(),
            anchor("center"),
            pos(500, 300),
            scale(0.5),
            "level2"
        ])
        add([
            sprite("level3"),
            area(),
            anchor("center"),
            pos(700, 300),
            scale(0.5),
            "level3"
        ])
        add([
            sprite("level4"),
            area(),
            anchor("center"),
            pos(900, 300),
            scale(0.5),
            "level4"
        ])
        add([
            sprite("level5"),
            area(),
            anchor("center"),
            pos(1100, 300),
            scale(0.5),
            "level5"
        ])
        add([
            sprite("level6"),
            area(),
            anchor("center"),
            pos(300, 500),
            scale(0.5),
            "level6"
        ])
        
        
        onClick("level1", () => {
            play("confirm-ui", { speed: 1.5 })
            go(1);
        });
        onClick("level2", () => {
            play("confirm-ui", { speed: 1.5 })
            go(2);
        });
        onClick("level3", () => {
            play("confirm-ui", { speed: 1.5 })
            go(3);
        });
        onClick("level4", () => {
            play("confirm-ui", { speed: 1.5 })
            go(4);
        });
        onClick("level5", () => {
            play("confirm-ui", { speed: 1.5 })
            go(5);
        });
        onClick("level6", () => {
            play("confirm-ui", { speed: 1.5 })
            go(6);
        });

    }

    displayControlsMenu() {
        add([
            sprite("forest-background"),

        ])
        add([
            text("Controlls", { font: "Round", size: 50 }),
            area(),
            anchor("center"),
            pos(center().x, center().y - 200)
        ])

        const controlPrompts = add([
            pos(center().x + 30, center().y)
        ])

        controlPrompts.add([
            sprite("up"),
            pos(0, -80)
        ])
        controlPrompts.add([sprite("down")])
        controlPrompts.add([sprite("left"), pos(-80, 0)])
        controlPrompts.add([sprite("right"), pos(80, 0)])
        controlPrompts.add([sprite("space"), pos(-200, 0)])
        
        controlPrompts.add([
            text("Jump", { font: "Round", size: 32 }),
            pos(-190, 100),
          ])

          controlPrompts.add([
            text("Move", { font: "Round", size: 32 }),
            pos(10, 100),
          ])
      
          this.displayBlinkingUIMessage(
            "Press [ Enter ] to Start Game",
            vec2(center().x + 35, center().y + 250)
          )
          
          onKeyPress("enter", () => {
            play("confirm-ui", { speed: 1.5 })
            go("levelmenu")
        })
    }

    displayGameOverScreen() {
        bgSoundManager.pauseAllSounds()
        add([rect(1280, 720), color(0, 0, 0)])
        add([
          text("Game Over!", { size: 50, font: "Round" }),
          area(),
          anchor("center"),
          pos(center()),
        ])
    
        this.displayBlinkingUIMessage(
          "Press [ Enter ] to Select Level",
          vec2(center().x, center().y + 100)
        )
    
        onKeyPress("enter", () => {
          play("confirm-ui")
          go("levelmenu")
        })
      }

      displayEndGameScreen() {
        bgSoundManager.pauseAllSounds()
        add([rect(1280, 720), color(0, 0, 0)])
        add([
          text("You Won! Thanks for Playing.", { size: 50, font: "Round" }),
          area(),
          anchor("center"),
          pos(center()),
        ])
    
        this.displayBlinkingUIMessage(
          "Press [ Enter ] to Play Again",
          vec2(center().x, center().y + 100)
        )
    
        onKeyPress("enter", () => {
          play("confirm-ui")
          go(1)
        })
      }

    addDarkBg() {
        add([
            rect(270, 130), 
            color(0, 0, 0),
            fixed() 
        ])
    }
}

export const uiManager = new UIManager()