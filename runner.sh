#!/bin/bash

# مسیر پروژه و فایل‌ها
PROJECT_DIR="$HOME/IdeaProjects/java-core"
TASKS_FILE="$PROJECT_DIR/tasks.json"

cd "$PROJECT_DIR" || exit

# بررسی وجود jq برای خواندن JSON
if ! command -v jq &> /dev/null; then
    echo "در حال نصب ابزار خواندن JSON (jq)..."
    sudo apt-get update && sudo apt-get install -y jq
fi

echo "🚀 شروع اجرای لیست کارها با 9router..."

# خواندن تعداد آیتم‌ها
TOTAL_TASKS=$(jq '. | length' "$TASKS_FILE")

for (( i=0; i<$TOTAL_TASKS; i++ )); do
    STATUS=$(jq -r ".[$i].status" "$TASKS_FILE")
    ID=$(jq -r ".[$i].id" "$TASKS_FILE")
    TITLE=$(jq -r ".[$i].title" "$TASKS_FILE")
    PROMPT=$(jq -r ".[$i].prompt" "$TASKS_FILE")

    if [ "$STATUS" == "pending" ]; then
        echo "------------------------------------"
        echo "📌 در حال اجرای کار شماره $ID: $TITLE"
        echo "------------------------------------"

        # اجرای دستور با مدل ترکیبی 9router
        # 9router در صورت اتمام توکن، خودکار مدل را عوض می‌کند
        opencode --model my-model "$PROMPT"

        # اگر اجرای دستور با موفقیت انجام شد، وضعیت تغییر کند
        if [ $? -eq 0 ]; then
            TMP_FILE=$(mktemp)
            jq ".[$i].status = \"completed\"" "$TASKS_FILE" > "$TMP_FILE" && mv "$TMP_FILE" "$TASKS_FILE"
            echo "✅ کار شماره $ID با موفقیت انجام و ذخیره شد."
        else
            echo "❌ در اجرای کار شماره $ID خطایی رخ داد. اجرای کارهای بعدی متوقف شد تا بررسی کنید."
            exit 1
        fi
    else
        echo "⏭️ کار شماره $ID قبلاً انجام شده است ($TITLE). رفتن به آیتم بعدی..."
    fi
done

echo "🎉 تمام کارهای موجود در لیست انجام شدند!"